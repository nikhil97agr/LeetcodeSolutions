class Solution {
    public String encode(String s) {
        int n = s.length();
        String dp[][] = new String[n][n];
        return solve(0, n-1, s, dp);
    }

    private String solve(int start, int end, String s, String dp[][]){
        if(dp[start][end]!=null) return dp[start][end];
        String sub = s.substring(start, end + 1);
        String res = sub;
        if(end - start + 1 < 4) return dp[start][end] = res;

        int len = (res+res).indexOf(res, 1);

        if(len < sub.length()){
            res = encode(sub, len);
        }

        for(int i=start;i<end;i++){
            String next = solve(start, i, s, dp) + solve(i+1, end, s, dp);
            int newLen = (next + next).indexOf(next, 1);
            if(newLen < next.length()){
                next = encode(next, newLen);
            }

            if(next.length() < res.length()){
                res = next;
            }
        }

        return dp[start][end] = res;
    }

    private String encode(String s, int len){
        int total = s.length() / len;
        String res = total + "["+s.substring(0, len)+"]";
        return res;
    }
}