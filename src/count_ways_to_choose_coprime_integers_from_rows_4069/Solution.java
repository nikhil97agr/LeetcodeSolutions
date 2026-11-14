package count_ways_to_choose_coprime_integers_from_rows_4069;

class Solution {
    public int countCoprime(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;
        int max = 0;
        for(int x[] : mat){
            for(int y : x){
                max = Math.max(max, y);
            }
        }
        Integer dp[][] = new Integer[m][max + 1];
        for(int i=0;i<n;i++){
            ans = add(ans, solve(mat, 1, mat[0][i], m, n, dp));
        }

        
        return ans;
    }

    private int solve(int mat[][], int row, int gcd, int m, int n, Integer dp[][]){
        if(row == m){
            if(gcd ==1 ) return 1;
            return 0;
        }

        if(dp[row][gcd] !=null) return dp[row][gcd];
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = add(ans, solve(mat, row+1, gcd(gcd, mat[row][i]), m, n, dp));
        }

        return dp[row][gcd] = ans;
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;
        long sum = 1l*a + b;

        return (int)(sum%mod);
    }
}
