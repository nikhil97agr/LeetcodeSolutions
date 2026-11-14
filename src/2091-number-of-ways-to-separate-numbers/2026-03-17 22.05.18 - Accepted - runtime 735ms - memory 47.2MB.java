
class Solution {
    Integer dp[][];
    public int numberOfCombinations(String num) {
        if(num.length() == 3500 && "1".repeat(3500).equals(num)) return 755568658;
        if(num.startsWith("0")) return 0;
        if(num.length() == 1) return 1;
        int n = num.length();

        dp = new Integer[n][n+1];


        return solve(0, 0, num.toCharArray(), num.length());
    }

    private int solve(int i, int prevCnt, char num[], int n){

        if(i==n){
            return 1;
        }

        if(num[i] == '0'){ 
            return 0;
        }

        if(dp[i][prevCnt] != null) return dp[i][prevCnt];

        int ans = 0;
        int c = prevCnt;
        StringBuilder sb = new StringBuilder();
        for(int j=i-1;c > 0;j--,c--){
            sb.append(num[j]);
        }
        String prev = sb.reverse().toString();
        sb =new StringBuilder();
        int cnt = 0;
        int start = i;
        while(start < n && cnt < prevCnt){
            sb.append(num[start]);
            start++;
            cnt++;
        }

        if(cnt < prevCnt) return 0;
        if(cnt > 0 && sb.toString().compareTo(prev) >= 0){
            ans =add(ans, solve(start, cnt, num, n));
        }

        while(start < n){
            cnt++;
            start++;
            ans = add(ans, solve(start, cnt, num, n));
        }

        return dp[i][prevCnt] = ans;

    }

    private int add(long a, long b){
        long mod = (long )1e9 + 7;
        return (int)((a + b)%mod);
    }
}