class Solution {
    public int fillCups(int[] amount) {
        Integer dp[][][] = new Integer[amount[0]+1][amount[1]+1][amount[2]+1];
        return solve(amount[0], amount[1], amount[2], dp);
    }

    private int solve(int h, int w, int c, Integer dp[][][]){
        if(dp[h][w][c] !=null) return dp[h][w][c];
        if(h==0 && w==0 && c==0){
            return 0;
        }

        if(h==0 && w==0){
            return dp[h][w][c]= c;
        }

        if(c==0 && w ==0) return dp[h][w][c]= h;
        if(h ==0 && c ==0) return dp[h][w][c]= w;

        if(c ==0 ){
            return dp[h][w][c]= 1+solve(h-1, w-1, c, dp);
        }

        if(h==0) return dp[h][w][c]= 1+solve(h, w-1, c-1, dp);

        if(w==0) return dp[h][w][c]= 1+solve(h-1, w, c-1, dp);

        return dp[h][w][c]= 1+Math.min(
            solve(h-1, w-1, c, dp),
            Math.min(solve(h, w-1, c-1, dp), solve(h-1, w,c-1, dp))
        );
    }


}