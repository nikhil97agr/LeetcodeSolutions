package minimum_string_length_after_balanced_removals_4090;

import java.util.*;
class Solution {
    public int minLengthAfterRemovals(String s) {
        Stack<Character> stack =new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }

            if(stack.peek()!=c) stack.pop();
            else stack.push(c);
        }

        return stack.size();
    }
}