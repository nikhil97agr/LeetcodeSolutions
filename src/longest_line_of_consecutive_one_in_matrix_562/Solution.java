package longest_line_of_consecutive_one_in_matrix_562;

import java.util.*;
class Solution {
    public int longestLine(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int dp[][] = new int[m][4];
        int ans = 0;
        if(mat[0][0]==1){
            dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = 1;
            ans = 1;
        }
        for(int i=1;i<m;i++){
            if(mat[0][i]==1){
                dp[i][0] = dp[i-1][0] +1;
                dp[i][1] = dp[i][2]  =dp[i][3] = 1;

                ans = max(ans, dp[i][0], dp[i][1], dp[i][2], dp[i][3]);
            }
        }

        for(int i=1;i<n;i++){
            int curr[][] = new int[m][4];
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    curr[j][0] = j>0 ? curr[j-1][0]+1 : 1;
                    curr[j][1] = dp[j][1] +1;
                    curr[j][2] = j>0 ? dp[j-1][2]+1 : 1;
                    curr[j][3] = j<m-1 ? dp[j+1][3] + 1 : 1;

                    ans = max(ans, curr[j][0], curr[j][1], curr[j][2], curr[j][3]);
                }
            }

            dp = curr;
        }

        
        return ans;

    }

    private int max(int...arr){
        return Arrays.stream(arr).max().getAsInt();
    }
}