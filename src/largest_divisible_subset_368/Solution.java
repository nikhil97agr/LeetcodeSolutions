package largest_divisible_subset_368;

import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int dp[] = new int[n];
        int prevInd[] = new int[n];
        Arrays.fill(prevInd, -1);
        Arrays.fill(dp, 1);
        int max = 1;
        int maxInd = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[j] + 1 > dp[i]){
                        prevInd[i] = j;
                    }
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }

                if(dp[i] > max){
                    max = dp[i];
                    maxInd = i;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while(maxInd != -1){
            res.add(nums[maxInd]);
            maxInd = prevInd[maxInd];
        }

        return res;
    }
}