package longest_non_decreasing_subarray_after_replacing_at_most_one_element_4098;

import java.util.Arrays;

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        int pre[] = new int[n+1];
        int suf[] = new int[n+1];
        pre[1] = 1;
        for(int i=1;i<n;i++){
            if(nums[i] >= nums[i-1]){
                pre[i+1] = pre[i] + 1;
            }else{
                pre[i+1] = 1;
            }
        }
        int ans= pre[n];
        suf[n-1] =1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] <= nums[i+1]){
                suf[i] = suf[i+1] +1 ;
            }else{
                suf[i] = 1;
            }
        }
        for(int i=1;i<n;i++){
            int cnt = pre[i];
            int cnt2 = suf[i+1];
            ans = Math.max(ans, Math.max(cnt, cnt2) +1);
            if(i+1 < n && nums[i+1] >= nums[i-1]){
                ans = Math.max(ans, cnt + cnt2+1);
            }
            
        }
        
        if(nums[0] > nums[1]){
            ans = Math.max(ans, 1 + suf[1]);
        }
        
        return ans;


    }
}