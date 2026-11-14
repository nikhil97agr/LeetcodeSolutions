package minimum_time_to_make_rope_colorful_1700;

import java.util.*;
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans  = 0;
        int n =colors.length();
        Stack<Integer> stack =new Stack<>();

        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            int peek = stack.peek();

            if(colors.charAt(peek) == colors.charAt(i)){
                if(neededTime[peek] > neededTime[i]){
                    ans += neededTime[i];
                    continue;
                }else{
                    ans += neededTime[stack.pop()];
                }
            }

            stack.push(i);
        }
        return ans;
    }
}