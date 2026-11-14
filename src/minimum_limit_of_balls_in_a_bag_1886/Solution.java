package minimum_limit_of_balls_in_a_bag_1886;

import java.util.*;
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int ans = 0;

        int start = 1;
        int end = Arrays.stream(nums).max().getAsInt();

        while(start <= end){
            int mid = start + (end-start)/2;

            if(check(mid, nums, maxOperations)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

    private boolean check(int mid, int nums[], int maxOperations){
        int count =0;

        for(int x : nums){
            int op = (int)Math.ceil(x/(1d*mid)) -1;

            count += op;

            if(count > maxOperations) return false;
        }
        return true;
    }
}