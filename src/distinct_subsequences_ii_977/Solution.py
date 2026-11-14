class Solution:
    def distinctSubseqII(self, s: str) -> int:
        mod = 1000000007
        n = len(s)
        dp = [1 for _ in range(n+1)]

        idx = [0 for _ in range(256)]

        for i in range(1, n+1):
            dp[i] = dp[i-1]*2
            x = ord(s[i-1])
            if idx[x]!=0:
                dp[i] -= dp[idx[x]-1]
            idx[x] = i
            dp[i]%=mod

        if dp[n]==0:
            return 1000000006
        return dp[n]-1
        