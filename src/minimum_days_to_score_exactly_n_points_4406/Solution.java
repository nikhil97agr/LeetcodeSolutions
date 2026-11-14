package minimum_days_to_score_exactly_n_points_4406;

import java.util.*;
class Solution {
    int dp[];
    public int minDays(int n) {
        int max = 550;
        int cnt[] = new int[max];
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int start = 1;
        for(int i=1;i<max;i++){
            cnt[i] = cnt[i - 1] + start;
            start++;
        }

        dp[0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<max && cnt[j] <= i;j++){
                dp[i] = Math.min(dp[i], dp[i - cnt[j]] + j + 1);
            }
        }

        return dp[n] - 1;
    }


}