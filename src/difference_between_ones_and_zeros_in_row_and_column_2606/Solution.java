package difference_between_ones_and_zeros_in_row_and_column_2606;

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int onecol[] = new int[n];
        int onerow[] = new int[m];
        int zerorow[] = new int[m];
        int zerocol[] = new int[n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    zerorow[i]++;
                    zerocol[j]++;
                }else{
                    onerow[i]++;
                    onecol[j]++;
                }
            }
        }
        int result[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j] = onerow[i]+onecol[j] - zerorow[i] - zerocol[j];
            }
        }
        return result;
    }
}