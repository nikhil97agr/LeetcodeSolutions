package parse_lisp_expression_736;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int evaluate(String expression) {
        return solve(expression, new HashMap<>());
    }

    private int solve(String exp, Map<String, Integer> map) {

        if (isNum(exp)) {
            return Integer.parseInt(exp);
        }

        if (isVar(exp)) {
            return map.get(exp);
        }

        List<String> parsed = parse(exp);

        if (parsed.get(0).equals("add")) {
            String a = parsed.get(1);
            String b = parsed.get(2);

            return solve(a, map) + solve(b, map);
        }

        if (parsed.getFirst().equals("mult")) {
            String a = parsed.get(1);
            String b = parsed.get(2);

            return solve(a, map) * solve(b, map);
        }

        Map<String, Integer> newMap = new HashMap<>(map);

        for (int i = 1; i < parsed.size() - 1; i += 2) {
            String var = parsed.get(i);
            String val = parsed.get(i + 1);

            newMap.put(var, solve(val, newMap));
        }

        return solve(parsed.getLast(), newMap);
    }

    private List<String> parse(String exp) {
        List<String> res=  new ArrayList<>();
        
        exp = exp.substring(1, exp.length()-1);
        
        int ind = 0;
        while(ind < exp.length()){
            int endIndex = nextToken(exp, ind);
            res.add(exp.substring(ind, endIndex));
            ind = endIndex + 1;
        }
        
        return res;
    }
    
    private int nextToken(String exp, int start){
        if(exp.charAt(start) != '('){

           int ind = exp.indexOf(' ', start);
           if(ind == -1) return exp.length();
           return ind;
        }
        
        int cnt = 1;
        start++;
        while(start <exp.length() && cnt > 0){
            if(exp.charAt(start) == '('){
                cnt++;
            }else if(exp.charAt(start) == ')'){
                cnt--;
            }
            
            start++;
        }
        return start;
    }

    private boolean isVar(String exp) {

        char ch = exp.charAt(0);
        return ch >= 'a' && ch <= 'z';
    }


    private boolean isNum(String exp) {

        char c = exp.charAt(0);

        return c == '-' || (c >= '0' && c <= '9');
    }
}