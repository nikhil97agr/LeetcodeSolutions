package magic_squares_in_grid_870;

import java.util.*;
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans =0 ;

        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){

                Set<Integer> set = new HashSet<>();
                for(int k=i;k<=i+2;k++){
                    for(int l=j;l<=j+2;l++){
                        if(grid[k][l] <=9 && grid[k][l]!=0)
                        set.add(grid[k][l]);
                    }
                }
                if(set.size() !=9) continue;
                int hsum = hsum(grid, i, j);
                int vsum = vsum(grid, i, j);
                int dsum = dsum(grid, i, j);

                if(hsum == vsum && hsum == dsum) ans++;
            }
        }

        return ans;
    }

    private int hsum(int grid[][], int x, int y){
        Set<Integer> sum = new HashSet<>();

        for(int i=x;i<=x+2;i++){
            int s = 0;
            for(int j=y;j<=y+2;j++){
                s += grid[i][j];
            }

            sum.add(s);
        }

        if(sum.size() == 1){
            for(int n : sum) return n;
        }

        return -1;
    }

    private int vsum(int grid[][], int x, int y){
        Set<Integer> sum = new HashSet<>();

        for(int i=y;i<=y+2;i++){
            int s = 0;
            for(int j=x;j<=x+2;j++){
                s += grid[j][i];
            }

            sum.add(s);
        }

        if(sum.size() == 1){
            for(int n : sum) return n;
        }

        return -3;
    }

    private int dsum(int grid[][], int x, int y){
        Set<Integer> sum = new HashSet<>();

        int s=0;
        for(int i=x,j=y;i<=x+2;i++,j++){
            s += grid[i][j];
        }
        sum.add(s);
        s =0;

        for(int i=x,j=y+2;i<=x+2;i++,j--){
            s+= grid[i][j];
        }

        sum.add(s);

        if(sum.size() == 1){
            for(int n : sum) return n;
        }

        return -2;
    }
}