package parsing_a_boolean_expression_1197;

import java.util.*;
class Solution {
    public boolean parseBoolExpr(String expression) {
        if(expression.charAt(0) == 't') return true;
        if(expression.charAt(0) == 'f') return false;
        Queue<Character> que = new LinkedList<>();
        for(char c : expression.toCharArray()){
            if(c == ',') continue;
            que.offer(c);
        }
        que.poll();
        return solve(que, expression.charAt(0));
    }

    private boolean solve(Queue<Character> que, char exp){
        int t = 0;
        int f = 0;
        while(!que.isEmpty()){
            char c = que.poll();
            if(c=='t'){
                t++;
                continue;
            }
            if(c == 'f'){
                f++;
                continue;
            }

            if(c == ')'){
                break;
            }
            if(c=='|' || c=='&' || c == '!'){
                boolean temp = solve(que, c);
                if(temp) t++;
                else f++;
            }
        }
        if(exp == '!'){
            if(t==0) return true;
            return false;
        }
        if(exp == '|'){
            if(t!=0) return true;
            return false;
        }
        if(f==0) return true;
        return false;
    }
}