package check_if_a_parentheses_string_can_be_valid_2221;

import java.util.*;
class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> unlock = new Stack<>();
        int n = s.length();
        if((n&1)==1) return false;
        for(int i=0;i<n;i++){
            char dig =locked.charAt(i);
            char c = s.charAt(i);
            if(dig == '0'){
                unlock.push(i);
            }else if(c=='('){
                open.push(i);
            }else{
                if(!open.isEmpty()){
                    open.pop();
                }else if(!unlock.isEmpty()){
                    unlock.pop();
                }else{
                    return false;
                }
            }
        }

        while(!unlock.isEmpty() && !open.isEmpty() && open.peek() < unlock.peek()){
            open.pop();
            unlock.pop();
        }

        return open.isEmpty();
    }
}