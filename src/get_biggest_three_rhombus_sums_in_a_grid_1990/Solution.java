package get_biggest_three_rhombus_sums_in_a_grid_1990;

import java.util.*;
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                set.add(grid[i][j]);
                if (set.size() > 3) {
                    set.removeFirst();
                }
            }
        }
        for (int len = 1; len <= Math.min(n, m); len++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (2 * len + i < n && i + len < n && j - len >= 0 && j + len < m) {
                        int sum = tl(i,j, i+len, j-len, grid) + tr(i,j,i+len, j+len, grid) + bl(i+2*len, j, i + len, j - len, grid) + br(i + 2*len, j, i + len, j + len, grid) - grid[i][j] - grid[i+2*len][j] - grid[i+len][j+len] - grid[i+len][j-len];
                        set.add(sum);
                        if (set.size() > 3) {
                            set.removeFirst();
                        }
                    }

                }
            }
        }

        int ans[] = new int[set.size()];
        int i = 0;
        while (!set.isEmpty()) {
            ans[i++] = set.removeLast();
        }

        return ans;

    }

    private int br(int i, int j, int n, int m, int grid[][]){
        int sum =0;
        while(i >=0 && j <=m){
            sum +=grid[i][j];
            i--;
            j++;
        }
        return sum;
    }

    private int bl(int i, int j, int n, int m, int grid[][]){
        int sum = 0;
        while(i >= n && j >= m){
            sum += grid[i][j];
            i--;
            j--;
        }
        return sum;
    }

    private int tr(int i, int j, int n, int m, int grid[][]){
        int sum = 0;
        while(i <=n && j <= m){
            sum += grid[i][j];
            i++;
            j++;
        }
        return sum;
    }

    private int tl(int i, int j, int n, int m, int grid[][]){
        int sum = 0;
        while(i <=n && j >= m){
            sum += grid[i][j];
            i++;
            j--;
        }
        return sum;
    }
}