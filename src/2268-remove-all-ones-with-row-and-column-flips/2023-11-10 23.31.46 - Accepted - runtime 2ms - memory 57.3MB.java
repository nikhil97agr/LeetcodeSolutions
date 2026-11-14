class Solution {
    public boolean removeOnes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n==1) return true;
        int count =0;

        for(int i=1;i<n;i++){
            if(Arrays.equals(grid[0], grid[i]))continue;
            count = 0;
            for(int j=0;j<m;j++){
                count += (grid[i][j]!=grid[0][j]) ? 1 : 0;
            } 

            if(count !=m) return false;
        }
        return true;
    }
}