class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        Integer dp[][] = new Integer[m][5000];

        return calculate(mat, dp, target, 0, 0, m, n);
        
    }

    public int calculate(int [][]mat, Integer dp[][], int target, int index, int sum, int m, int n){
        if(index==m){
            return Math.abs(target-sum);
        }

        if(dp[index][sum]!=null){
            return dp[index][sum];
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res = Math.min(res, calculate(mat, dp, target, index+1, sum + mat[index][i],m ,n));
        }

        dp[index][sum] = res;
        return dp[index][sum];
    }
}