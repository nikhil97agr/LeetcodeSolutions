package right_triangles_3388;

class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        long ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        long row[] = new long[n];
        long col[] = new long[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans += (row[i]-1)*(col[j]-1);
                }
            }
        }
        return ans;
    }
}