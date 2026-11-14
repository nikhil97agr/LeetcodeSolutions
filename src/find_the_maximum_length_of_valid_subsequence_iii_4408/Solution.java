package find_the_maximum_length_of_valid_subsequence_iii_4408;

import java.util.*;
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int ind[] = new int[k];
        Arrays.fill(ind, -1);

        int next[] = new int[n];
        Arrays.fill(next, -1);
        for(int i = n-1;i>=0;i--){

            int mod = nums[i]%k;
            int req =0 ;
            if(mod !=0){
                req = k - mod;
            }

            next[i] = ind[req];
            ind[mod] = i;
        }

        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0;i<n;i++){
            int nxt = next[i];
            if(nxt != -1){
                dp[nxt] = Math.max(dp[nxt], dp[i] + 1);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}