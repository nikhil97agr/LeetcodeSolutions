import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder sb =new StringBuilder(s);
        TreeMap<Integer, Set<String>> map =new TreeMap<>();

        generate(sb, map, 0,  0);

        return map.firstEntry().getValue().stream().toList();
    }

    private void generate(StringBuilder sb, TreeMap<Integer, Set<String>> map, int i,  int del) {


        if(i==sb.length()){
            if(isValid(sb.toString())){
                map.computeIfAbsent(del, a-> new HashSet<>()).add(sb.toString());
            }

            return;
        }

        char c = sb.charAt(i);

        generate(sb, map, i+1,  del);

        if(c=='(' || c==')'){
            sb.deleteCharAt(i);
            generate(sb, map, i, del+1);
            sb.insert(i, c);
        }
    }


    private boolean isValid(String s){
        int start = 0;


        for(char c : s.toCharArray()){
            if(c=='('){
                start++;
            }else if(c==')'){
                if(start ==0) return false;
                start--;
            }
        }

        return start ==0;
    }
}