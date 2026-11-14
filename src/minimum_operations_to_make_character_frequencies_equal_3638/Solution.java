package minimum_operations_to_make_character_frequencies_equal_3638;

class Solution {
    public int makeStringGood(String s) {
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        int cnt[] = new int[26];
        for(char c : s.toCharArray()) cnt[c-'a']++;

        int min = n + 1;
        int max = 0;
        for(int c : cnt){
            if(c > 0){
                min = Math.min(min , c);
                max = Math.max(max, c);
            }
        }
        if(min == max) return 0;
        int dp[][] = new int[26][2];
        for(int target = min;target <= max;target++){
            dp[0][0] = cnt[0];
            dp[0][1] = Math.abs(cnt[0] - target);
            for(int j=1;j<26;j++){
                dp[j][0]= Math.min(dp[j-1][0], dp[j-1][1]) + cnt[j];
                if(cnt[j] >= target){
                    dp[j][1] = Math.min(dp[j-1][0], dp[j-1][1]) + (cnt[j] - target);
                }else{
                    int c1 = target - Math.min(target, cnt[j] + cnt[j-1]);
                    int a = Math.max(0, cnt[j-1] - target);
                    int c2 = target - Math.min(target, cnt[j] + a);
                    dp[j][1] = Math.min(dp[j-1][0] + c1, dp[j-1][1] + c2);
                }
            }
            ans = Math.min(ans, Math.min(dp[25][0], dp[25][1]));
        }
        return ans;
    }
}