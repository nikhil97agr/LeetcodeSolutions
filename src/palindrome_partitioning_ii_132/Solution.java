package palindrome_partitioning_ii_132;

class Solution {
    public int minCut(String s) {
        var n = s.length();
        char ch[] = s.toCharArray();
        boolean pal[][] = new boolean[n][n];
        for(var i=0;i<n;i++) pal[i][i] = true;

        for(int i =n - 1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if( j - i ==1){
                    if(ch[i] == ch[j]){
                        pal[i][j] = true;
                    }
                }else{
                    if(ch[i] == ch[j])
                    pal[i][j] = pal[i+1][j-1];
                }
            }
        }

        if(pal[0][n-1]) return 0;

        Integer dp[][] = new Integer[n][n];

        return solve(0, 0, n, dp, pal);
    }

    private int solve(int start, int end, int n, Integer dp[][], boolean pal[][]){
        if(start == end && start == n){
            return -1;
        }

        if(end ==n){
            return Integer.MAX_VALUE;
        }

        if(dp[start][end] !=null) return dp[start][end];

        int a= solve(start, end + 1, n, dp, pal);
        int b = Integer.MAX_VALUE;
        if(pal[start][end]){
            b = solve(end +1, end + 1, n, dp, pal);
            if(b != Integer.MAX_VALUE){
                b++;
            }
        }

        return dp[start][end] = Math.min(a,b);
    }
}