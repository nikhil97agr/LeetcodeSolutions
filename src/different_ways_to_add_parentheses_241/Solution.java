package different_ways_to_add_parentheses_241;

import java.util.*;
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        if(expression.isEmpty()) return result;

        if(expression.length() == 1){
            result.add(Integer.parseInt(expression));
            return result;
        }

        if(expression.length() ==2 && Character.isDigit(expression.charAt(0))){
            result.add(Integer.parseInt(expression));
            return result;
        }

        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);

            if(Character.isDigit(c)) continue;

            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            List<Integer> right = diffWaysToCompute(expression.substring(i+1));

            for(int leftVal : left){
                for(int rightVal : right){
                    int ans = 0;
                    switch(c){
                        case '*' : ans = rightVal *leftVal; break;
                        case '+' : ans = leftVal +rightVal; break;
                        case '-' : ans = leftVal - rightVal;break;
                        case '/' : ans = leftVal / rightVal;
                        break;
                    }
                    result.add(ans);
                }
            }
        }


        return result;
    }
}