package longest_alternating_subarray_after_removing_at_most_one_element_4198;

import java.util.*;
import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int longestAlternating(int[] nums) {
        int n = nums.length;

        int pre[] = new int[n];
        int suff[] = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(suff, 1);

        boolean prevIncr = true;

        for(int i=1;i<n;i++){
            if(prevIncr){
                if(nums[i] < nums[i-1]){
                    pre[i] = pre[i-1] + 1;
                    prevIncr = false;
                }else if(nums[i] > nums[i-1]){
                    pre[i] = 2;
                }
            }else{
                if(nums[i] > nums[i-1]){
                    pre[i] = pre[i-1] + 1;
                    prevIncr = true;
                }else if(nums[i] < nums[i-1]){
                    pre[i] = 2;
                }
            }
        }
        prevIncr = true;
        for(int i=n-2;i>=0;i--){
            if(prevIncr){
                if(nums[i] < nums[i+1]){
                    suff[i] = suff[i+1] + 1;
                    prevIncr = false;
                }else if(nums[i] > nums[i+1]){
                    suff[i] = 2;
                }
            }else{
                if(nums[i] > nums[i+1]){
                    suff[i] = suff[i+1] + 1;
                    prevIncr = true;
                }else if(nums[i] < nums[i+1]){
                    suff[i] = 2;
                }
            }
        }

        if(suff[0] == n) return n;
        int ans = Math.max(Arrays.stream(pre).max().getAsInt(), Arrays.stream(pre).max().getAsInt());
        for(int i=1;i<n-1;i++){
            int l1 = pre[i-1];
            int l2 = suff[i+1];
            if(nums[i-1] == nums[i+1]) continue;
            if(nums[i-1] < nums[i+1]){
                if(i-2 < 0 || nums[i-2] > nums[i-1]){
                    if(i+2 >=n || nums[i+2] < nums[i+1]){
                        ans = Math.max(ans, l1 + l2);
                    }
                }
                
                if(i +2 >=n || nums[i+2] < nums[i+1]){
                    ans = Math.max(ans, 1 + l2);
                }
                
                if(i-2 < 0 || nums[i-2] > nums[i-1]){
                    ans = Math.max(ans, l1 + 1);
                }
                
                ans = Math.max(ans, 2);
                
                continue;
            }
            
            if(i-2 < 0 || nums[i-2] < nums[i-1]){
                if(i+2 >=n || nums[i+2] > nums[i+1]){
                    ans = Math.max(ans, l1 + l2);
                }
            }
            
            if(i+2 >=n || nums[i+2] > nums[i+1]){
                ans = Math.max(ans, l2 + 1);
            }
            if(i-2 < 0 || nums[i-2] < nums[i-1]){
                ans = Math.max(ans, l1 + 1);
            }
            ans = Math.max(ans, 2);
        }
        return ans;
    }

}