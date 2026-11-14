package lexicographically_smallest_negated_permutation_that_sums_to_target_4077;

import java.util.*;
class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        int ans[] =new int[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            ans[i] = i+1;
            sum += ans[i];
        }

        if(target < -sum || sum < target) return new int[0];
        long diff = Math.abs(sum - target);

        if(diff%2==1l) return new int[0];

        for(int i=n-1;i>=0;i--){
            if(2l*ans[i] <= diff){
                ans[i] = -ans[i];
                diff += 2l*ans[i];
            }
        }
    Arrays.sort(ans);
        return ans;
    }
}