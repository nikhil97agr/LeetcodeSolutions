class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int ans = 0;
        for(int j=0;j<n;j++){
            ans+= fruits[j][j];
            fruits[j][j] = 0;
        }

        Integer dp[][] = new Integer[n][n];



        return ans + solveDown(0, n-1, n, fruits, new Integer[n][n]) + solveRight(n-1, 0, n, fruits, new Integer[n][n]);

    }

    private int solveRight(int i, int j, int n, int fruits[][], Integer dp[][]){
        if(i < 0 || i >=n || j>= n){
            return Integer.MIN_VALUE;
        }

        if(i==n-1 && j== n-1){
            return 0;
        }

        if(dp[i][j] !=null) return dp[i][j];

        int ans = Integer.MIN_VALUE;
        int diff[] = new int[]{1, 0, -1};

        for(int x : diff){
            int temp = solveRight(i+x, j + 1, n, fruits, dp);

            if(temp != Integer.MIN_VALUE){
                ans = Math.max(ans, temp + fruits[i][j]);
            }
        }


        return dp[i][j] = ans;
    }
    

    private int solveDown(int i, int j, int n, int fruits[][], Integer dp[][]){
        if(j < 0 || j >=n || i>= n){
            return Integer.MIN_VALUE;
        }

        if(i==n-1 && j== n-1){
            return 0;
        }

        if(dp[i][j] !=null) return dp[i][j];

        int ans = Integer.MIN_VALUE;
        int diff[] = new int[]{1, 0, -1};

        for(int x : diff){
            int temp = solveDown(i+1, j + x, n, fruits, dp);

            if(temp != Integer.MIN_VALUE){
                ans = Math.max(ans, temp + fruits[i][j]);
            }
        }


        return dp[i][j] = ans;
    }
}