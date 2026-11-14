package surface_area_of_3d_shapes_928;

class Solution {
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        int n = grid.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans += (grid[i][j] ==0) ? 0 : (2 + 4*grid[i][j]);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j+1 < n ){
                     ans -= 2*Math.min(grid[i][j], grid[i][j+1]);
                }

                if(i+1 < n){
                    ans -= 2*Math.min(grid[i][j], grid[i+1][j]);
                }
            }
        }

        return ans;
    }
}