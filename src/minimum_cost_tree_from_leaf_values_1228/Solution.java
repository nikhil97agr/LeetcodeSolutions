package minimum_cost_tree_from_leaf_values_1228;

class Solution {
    public int mctFromLeafValues(int[] arr) {
        
        Integer dp[][] = new Integer[arr.length][arr.length];
        return solve(0, arr.length-1, arr, dp);
    }

    private int solve(int i, int j, int arr[], Integer dp[][]){
        if(i>=j) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            ans = Math.min(ans, solve(i,k, arr, dp) + solve(k+1, j, arr, dp) + max(arr, i, k)*max(arr, k+1, j));
        }

        return dp[i][j] = ans;
    }

    private int max(int arr[], int i, int j){
        int max= 0;
        while(i <= j){
            max = Math.max(max, arr[i]);
            i++;
        }

        return max;
    }
}