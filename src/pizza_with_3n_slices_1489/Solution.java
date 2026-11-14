package pizza_with_3n_slices_1489;

import java.util.*;
import java.util.Arrays;

class Solution {

    public int maxSizeSlices(int[] slices) {

        int n = slices.length - 1;
        int k = (n+1) / 3;
        int a[] = Arrays.copyOfRange(slices, 0, n);
        int b[] = Arrays.copyOfRange(slices, 1, n + 1);
        
        return Math.max(solve(a, 0, k, new Integer[n+1][k+1]), solve(b, 0, k, new Integer[n+1][k+1]));
    }
    
    private int solve(int arr[], int i, int k, Integer dp[][]){
        if( k == 0) return 0;
        if(i >= arr.length) return Integer.MIN_VALUE;
        if(dp[i][k] !=null) return dp[i][k];
        int ans = solve(arr, i +1, k, dp);
        int b = solve(arr, i+2, k - 1, dp);
        if(b != Integer.MIN_VALUE){
            ans = Math.max(ans, arr[i] + b);
        }
        
        return dp[i][k] = ans;
    }
    
}