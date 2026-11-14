package largest_magic_square_1311;

import java.util.*;
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int len = Math.min(m, n);len > 1;len--){
            for(int i=0;i+len <= m ;i++){
                for(int j=0;j+len <= n;j++){
                    Set<Integer> row = row(grid, i, j, len);
                    Set<Integer> col = col(grid, i, j, len);
                    Set<Integer> diag = diag(grid, i, j, len);

                    row.addAll(col);
                    row.addAll(diag);
                    if(row.size() == 1) return len;
                }
            }
        }
        return 1;
    }

    private Set<Integer> row(int grid[][], int i, int j, int len){
        Set<Integer> set = new HashSet<>();

        for(int k=i;k-i < len ;k++){
            int sum =0;
            for(int l=j;l-j < len;l++){
                sum += grid[k][l];
            }
            set.add(sum);
        }

        return set;
    }

    private Set<Integer> col(int grid[][], int i, int j, int len){
        Set<Integer> set = new HashSet<>();

        for(int k=j;k-j < len ;k++){
            int sum =0;
            for(int l=i;l-i < len;l++){
                sum += grid[l][k];
            }
            set.add(sum);
        }

        return set;
    }

    private Set<Integer> diag(int grid[][], int i, int j, int len){
        Set<Integer> set = new HashSet<>();
        int sum =0;
        for(int k=i,l=j; k - i < len;k++,l++){
            sum += grid[k][l];
        }

        set.add(sum);
        sum = 0;
        for(int k=i, l = j + len - 1;l >= j;k++,l--){
            sum += grid[k][l];
        }
        set.add(sum);
        return set;
    }
}