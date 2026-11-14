package minimum_string_length_after_removing_substrings_2800;

import java.util.*;
class Solution {
    public int minLength(String s) {
        int i=0;
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='B'){
                if(!stack.isEmpty() && stack.peek() == 'A'){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else if(c=='D'){
                if(!stack.isEmpty() && stack.peek() == 'C'){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        return stack.size();
    }
}