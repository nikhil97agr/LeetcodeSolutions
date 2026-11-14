class Solution {
    public int minimumLines(int[][] points) {
        int n= points.length;
        int slop[][] = new int[n][n];
        Integer dp[] = new Integer[1<<n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                slop[i][j] = (1<<i) | (1<<j);
                int x1 = points[i][0] - points[j][0];
                int y1 = points[i][1] - points[j][1];
                for(int k=0;k<n;k++){
                    if(i==k || j==k) continue;

                    int x2 = points[i][0] - points[k][0];
                    int y2 = points[i][1] - points[k][1];

                    if(x1 * y2 == x2 * y1){
                        slop[i][j] |= (1<<k);
                    }
                }
            }
        }

        return solve(0, slop, n, dp);
    }

    private int solve(int mask, int slop[][], int n, Integer dp[]){

        if(dp[mask]!=null) return dp[mask];
        int bits = Integer.bitCount(mask);

        if(bits == n) return 0;

        if(bits >= n-2) return 1;

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;

                if((mask & (slop[i][j]))==0){
                    int x = solve(mask | slop[i][j], slop, n, dp);

                    if(x != Integer.MAX_VALUE){
                        ans = Math.min(ans, 1 + x);
                    }
                }
            }
        }

        return dp[mask] = ans;
    }
}