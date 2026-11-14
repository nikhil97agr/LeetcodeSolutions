class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        long mod = 12345l;
        long prod = 1l;
        int n = grid.length;
        int m = grid[0].length;
        int p[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                p[i][j] = (int)(prod%mod);
                prod *= grid[i][j];
                prod %= mod;
            }
        }
        prod = 1l;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                p[i][j] = (int)((1l*p[i][j]*prod)%mod);
                prod *= grid[i][j];
                prod %= mod;
            }
        }
        return p;
    }
}