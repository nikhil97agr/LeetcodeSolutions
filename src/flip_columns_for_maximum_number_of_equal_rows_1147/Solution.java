package flip_columns_for_maximum_number_of_equal_rows_1147;

import java.util.*;
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<m;j++){
                if(matrix[i][0] == matrix[i][j]) sb.append("T");
                else sb.append("F");
            }

            String s = sb.toString();

            map.put(s, map.getOrDefault(s, 0)+1);
        }

        int ans = 0;
        for(int val : map.values()) ans = Math.max(ans, val);
        return ans;
    }
}