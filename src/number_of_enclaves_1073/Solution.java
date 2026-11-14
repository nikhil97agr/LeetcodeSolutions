package number_of_enclaves_1073;

import java.util.*;
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];

        int total = 0;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    visited[i][j]=true;
                }
                if(grid[i][j]==1){
                    total++;
                }
                if((i==0 || j==0 || i==m-1 || j==n-1) && grid[i][j]==1){
                    visited[i][j]= true;
                    count++;
                    que.add(new int[]{i,j});
                }
            }
        }
        int diff[] = new int[]{0,1,0,-1,0};
        while(!que.isEmpty()){
            int p[] = que.poll();
            for(int i=0;i<4;i++){
                int row = p[0] + diff[i+1];
                int col = p[1] + diff[i];

                if(row<0 || col <0 || row >=m || col>=n || visited[row][col]){
                    continue;
                }

                count++;
                visited[row][col] = true;
                que.add(new int[]{row, col});
            }
        }

        return total - count;
    }
}