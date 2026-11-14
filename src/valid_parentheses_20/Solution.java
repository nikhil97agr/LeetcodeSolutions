package valid_parentheses_20;

import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(isOpen(c)){
                    stack.push(c);
                    continue;
                }

            if(stack.isEmpty()){
                return false;
            }

            if(!isMatch(stack.peek(), c)){
                return false;
            }else{
                stack.pop();
            }
            

        }
        return stack.isEmpty();
    }

    private boolean isMatch(char c1, char c2){
        if(c1=='{' && c2=='}') return true;
        if(c1=='(' && c2==')') return true;

        if(c1=='[' && c2==']') return true;
        return false;
    }
    
    private boolean isOpen(char c){
        return c=='(' || c=='{' || c=='[';
    }

}