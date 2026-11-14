package longest_harmonious_subsequence_594;

import java.util.*;
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        int start = 0;
        int end = 0;
        int n = nums.length;
        while(end < n){
            if(nums[end] - nums[start] == 1){
                ans = Math.max(ans, end - start + 1);
            }else if(nums[end] - nums[start] != 0){
                while(nums[end] - nums[start] > 1){
                    start++;
                }
                if(nums[start] != nums[end]){
                    ans = Math.max(ans, end- start + 1);
                }
            }
            end++;
        }
        return ans;
    }
}