package longest_subsequence_with_limited_sum_2469;

import java.util.*;
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int ans[] = new int[m];
        Arrays.fill(ans, -1);
        for(int i=0;i<m;i++){
            int sum = 0;
            
            for(int j=0;j<n;j++){
                if(sum+nums[j]>queries[i]){
                    ans[i] = j;
                    break;


                }else{
                    sum += nums[j];
                }
            }
            if(ans[i]==-1){
                ans[i] = n;
            }
        }
        return ans;
    }
}