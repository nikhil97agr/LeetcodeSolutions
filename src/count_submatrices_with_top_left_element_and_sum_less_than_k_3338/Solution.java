package count_submatrices_with_top_left_element_and_sum_less_than_k_3338;



class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;

        int colSum[] = new int[m];
        for(int i=0;i<n;i++){
            int s = 0;
            for(int j=0;j<m;j++){
                int sum  = s+ grid[i][j] + colSum[j];
                s += grid[i][j];
                if(sum <= k){
                    cnt++;
                }
                colSum[j] = sum;
                
            }
        }
        return cnt;
    }

}