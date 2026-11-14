package check_if_word_is_valid_after_substitutions_1045;

import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=s.length() -1 ;i>=0;i--){
            char c = s.charAt(i);

            if(c=='a'){
                if(stack.size() < 2) return false;
                if(stack.pop()!='b' || stack.pop() !='c') return false;
                continue;
            }

            stack.push(c);
            
        }

        return stack.isEmpty();
    }
}