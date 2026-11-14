package check_if_all_1s_are_at_least_length_k_places_away_1548;

import java.util.*;
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                stack.push(i);
            }
        }
        if(stack.size() <= 1) return true;
        int x = stack.pop();
        while(!stack.isEmpty()){
            if(x - stack.peek() <= k) return false;
            x = stack.pop();
        }
        return true;
    }
}