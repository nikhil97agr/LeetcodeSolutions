package lucky_numbers_in_a_matrix_1496;

import java.util.*;
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int row[] = new int[m];
        Arrays.fill(row, Integer.MAX_VALUE);
        int col[] = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == row[i] && matrix[i][j] == col[j]){
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}