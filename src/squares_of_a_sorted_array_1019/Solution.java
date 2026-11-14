package squares_of_a_sorted_array_1019;

import java.util.*;
class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = nums[i]*nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}