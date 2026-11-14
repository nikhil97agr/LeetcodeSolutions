package palindrome_partitioning_iii_1403;

class Solution {
    public int palindromePartition(String s, int k) {
        Integer dp[][][] = new Integer[s.length()][s.length()][k+1];
        return solve(s.toCharArray(), 0, 0, s.length(), k, dp);
    }

    private int solve(char ch[], int start, int end, int n, int k, Integer dp[][][]){
        if(end == n){
            if(start != end){
              return Integer.MAX_VALUE;
            }
            if(k==0){
                return 0;
            }

            return Integer.MAX_VALUE;
        }
        if(k==0){
            return Integer.MAX_VALUE;
        }

        if(dp[start][end][k]!=null) return dp[start][end][k];
        int ans = Integer.MAX_VALUE;;
        int cnt = 0;
        for(int i=start, j=end;i<j;i++,j--){
            if(ch[i] != ch[j]){
                cnt++;
            }
        }

        int a = solve(ch, end+1, end+1, n, k-1, dp);
        int b = solve(ch, start, end+1, n, k, dp);

        if(a != Integer.MAX_VALUE){
            ans = Math.min(ans, cnt + a);
        }

        return dp[start][end][k] = Math.min(ans, b);
        
    }
}