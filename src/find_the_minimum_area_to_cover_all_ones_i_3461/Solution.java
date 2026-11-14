package find_the_minimum_area_to_cover_all_ones_i_3461;

class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m= grid[0].length;

        int sr = n-1, er = 0, sc = m-1, ec = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==1){
                    sr = Math.min(sr, i);
                    er = Math.max(er, i);
                    sc = Math.min(sc, j);
                    ec = Math.max(ec, j);
                }
            }
        }



        int r = sr > er ? 0 : er - sr + 1;
        int c = sc > ec ? 0 : ec - sc + 1;


        return r * c;
    }
}