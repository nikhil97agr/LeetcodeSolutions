package check_knight_tour_configuration_2662;

class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0){
            return false;
        }
        
        int n = grid.length;
        Boolean visited[][] = new Boolean[n][n];
        
        return solve(grid, visited, 0, 0, n, 0);
    }
    
    private boolean solve(int grid[][], Boolean visited[][], int i, int j, int n, int nextMove){
        if(nextMove == n*n){
            return true;
        }
        if(!valid(i,j,n)){
            return false;
        }
        if(grid[i][j]!=nextMove){
            return false;
        }
        if(visited[i][j]!=null){
            return visited[i][j];
        }
        
        visited[i][j] = true;
        
        if( solve(grid, visited,i+2 ,j+1,n, nextMove+1) || 
            solve(grid, visited,i+2 ,j-1,n, nextMove+1) || 
            solve(grid, visited,i+1 ,j-2,n, nextMove+1) ||
            solve(grid, visited,i-1 ,j-2,n, nextMove+1) ||
            solve(grid, visited,i-2 ,j-1,n, nextMove+1) ||
            solve(grid, visited,i-2 ,j+1,n, nextMove+1) ||
            solve(grid, visited,i-1 ,j+2,n, nextMove+1) ||
            solve(grid, visited,i+1 ,j+2,n, nextMove+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
        
    }
    
    private boolean valid(int i, int j, int n){
        return i>=0 && i<n && j>=0 && j<n;
    }
}