class Solution {
    long mod = (long)1e9 + 7;
    public int countTexts(String pressedKeys) {
        Map<Character, Integer> map = Map.of('2' ,3 ,'3' ,3 ,'4' ,3 ,'5' ,3,'6' ,3, '7' ,4, '8',3, '9' ,4);
        int ans = 1;
        char prev = pressedKeys.charAt(0);

        int cnt = 0;
        for(char c: pressedKeys.toCharArray()){
            if(prev == c){
                cnt++;
            }else{
                ans = prod(ans, solve(0, cnt, map.get(prev), new Integer[cnt]));
                cnt= 1;
                prev = c;
            }
        }

        ans = prod(ans, solve(0, cnt, map.get(prev), new Integer[cnt]));
        return ans;
    }

    private int solve(int i, int n, int maxLen, Integer dp[]){
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] !=null) return dp[i];
        int ans = 0;
        for(int j=1;j<=maxLen;j++){
            ans =add(ans, solve(i+j, n, maxLen, dp));
        }

        return dp[i] = ans;
    }

    private int add(long a, long b){
        long sum = a+b;

        return (int)(sum%mod);
    }

    private int prod(long a, long b){
        long p = a * b;
        return (int)(p%mod);
    }
}

/**

    222
    aaa
    ab
    c
    ba

 */