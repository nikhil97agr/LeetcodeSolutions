package removing_stars_from_a_string_2470;

import java.util.*;
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='*'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        char result[] = new char[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            result[i] = stack.pop();
        }
        return String.valueOf(result);
    }
}