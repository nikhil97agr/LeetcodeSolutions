package cyclically_rotating_a_grid_2043;

import java.util.*;
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n =grid[0].length;
        int mid = Math.min(m,n)/2;
        for(int i=0;i<mid;i++){
            List<int[]> indices = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            Queue<int[]> que= new LinkedList<>();


            for(int j=i;j<n-1-i;j++){
                indices.add(new int[]{i, j});
                values.add(grid[i][j]);
            }

            for(int j=i;j<m-1-i;j++){
                indices.add(new int[]{j, n-1-i});
                values.add(grid[j][n-1-i]);
            }

            for(int j=n-1-i;j>i;j--){
                indices.add(new int[]{m-1-i, j});
                values.add(grid[m-1-i][j]);
            }

            for(int j=m-i-1;j>i;j--){
                indices.add(new int[]{j,i});
                values.add(grid[j][i]);
            }

            int res[] =new int[values.size()];
            int size = values.size();
            int rem = k%size;

            for(int ind=0;ind < size;ind++){
                int ni = (ind - rem + size)%size;
                res[ni] = values.get(ind);
            }

            for(int ind =0;ind < size;ind++){
                int index[] = indices.get(ind);
                grid[index[0]][index[1]] = res[ind];
            }
            
            
        }
        
        return grid;
    }
}