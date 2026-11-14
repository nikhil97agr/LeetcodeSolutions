package projection_area_of_3d_shapes_919;

class Solution {
    public int projectionArea(int[][] grid) {
        int n =grid.length;
        int ans = 0;

        for(int i=0;i<n;++i){
            int mr = 0;
            int mc = 0;

            for(int j=0;j<n;++j){
                if(grid[i][j] > 0){
                    ans++;
                }

                mr = Math.max(mr, grid[i][j]);
                mc =Math.max(mc, grid[j][i]);
            }

            ans += mr+mc;
        }

        return ans;
    }
}