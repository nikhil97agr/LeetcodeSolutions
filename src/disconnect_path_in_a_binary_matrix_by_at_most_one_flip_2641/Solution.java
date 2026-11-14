package disconnect_path_in_a_binary_matrix_by_at_most_one_flip_2641;

class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        if(dfs(grid, 0, 0) == 0) return true;

        grid[0][0] = 1;
        return dfs(grid, 0, 0) == 0;
    }
    private int dfs(int grid[][], int i, int j){
        if(i==grid.length-1 && j== grid[0].length-1) return 1;
        if(i == grid.length || j == grid[0].length || grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        if(dfs(grid, i+1, j) == 1) return 1;

        return dfs(grid, i, j+1);
    }
}