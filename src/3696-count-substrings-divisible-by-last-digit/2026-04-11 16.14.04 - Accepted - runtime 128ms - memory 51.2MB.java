class Solution {
    public long countSubstrings(String s) {
        var n = s.length();
        var dp = new long[10][10];

        var ans = 0l;

        for(var d : s.toCharArray()){
            var digit = d - '0';

            for(var mod = 1;mod <= 9;mod++){
                var cnt = new long[mod];
                cnt[digit%mod]++;
                for(var reminder =0;reminder < mod;reminder++){
                    var newMod = (reminder *10 + digit) %mod;
                    cnt[newMod] += dp[mod][reminder];

                }

                dp[mod] = cnt;

            }

            ans += dp[digit][0];
        }



        return ans;

        


    }
}