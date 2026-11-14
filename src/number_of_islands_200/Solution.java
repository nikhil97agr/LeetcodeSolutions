package number_of_islands_200;

class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    result ++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        
        return result;
    }
    public void dfs(char grid[][], int i, int j, int row, int col){
            if(i<0||j<0||i>=row||j>=col){
                return;
            }
            
            if(grid[i][j]=='1'){
                grid[i][j] = '0';
                dfs(grid, i-1, j, row, col);
                dfs(grid, i+1,j,row,col);
                dfs(grid, i, j-1, row, col);
                dfs(grid, i, j+1, row, col);
            }
        }
}