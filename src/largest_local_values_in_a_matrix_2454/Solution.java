package largest_local_values_in_a_matrix_2454;

import java.util.*;
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int ans[][] = new int[n-2][n-2];

        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                ans[i][j] = max(grid[i][j],
                                grid[i+1][j],
                                grid[i+2][j],
                                grid[i][j+1],
                                grid[i+1][j+1],
                                grid[i+2][j+1],
                                grid[i][j+2],
                                grid[i+1][j+2],
                                grid[i+2][j+2]);
            }
        }

        return ans;
    }

    private int max(int...arr){
        return Arrays.stream(arr).max().getAsInt();
    }
}