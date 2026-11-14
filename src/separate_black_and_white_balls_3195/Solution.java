package separate_black_and_white_balls_3195;

import java.util.*;
class Solution {
    public long minimumSteps(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                stack.push(i);
            }

        }
        long ans = 0;
        for(int i=0;i<s.length() && !stack.isEmpty();i++){
            ans += 1L*(stack.pop() - i);
        }

        return ans;
    }
}