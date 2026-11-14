package minimum_substring_partition_of_equal_character_frequency_3403;

class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        Integer dp[] = new Integer[n+1];
        return solve(0, dp, s, n);
    }

    private int solve(int i, Integer dp[], String s, int n){
        if(i==n) return 0;

        if(dp[i]!=null) return dp[i];

        int ans = 10000;
        int cnt[] = new int[26];
        for(int j=i;j<n;j++){
            char c =s.charAt(j);

            cnt[c-'a']++;
            int max = -1;
            int min = 10000;
            for(int x : cnt){
                if(x > 0){
                    max = Math.max(max, x);
                    min = Math.min(min, x);
                }
            }

            if(min == max){
                ans = Math.min(ans, 1 + solve(j+1, dp, s, n));
            }
        }
        return dp[i] = ans;
    }
}