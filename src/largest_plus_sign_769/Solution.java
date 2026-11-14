package largest_plus_sign_769;

import java.util.*;
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int grid[][] = new int[n][n];
        for (int m[] : mines) {
            int i = m[0];
            int j = m[1];
            grid[i][j] = 1;
        }

        int hCnt[][][] = hCnt(n, grid);
        int vCnt[][][] = vCnt(n, grid);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    continue;
                int min = min(hCnt[i][j][0], vCnt[i][j][0], hCnt[i][j][1], vCnt[i][j][1]);
                ans = Math.max(ans, min);
            }
        }
         return ans;
    }

    private int[][][] vCnt(int n, int grid[][]) {
        int cnt[][][] = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 0) {
                    c++;
                } else {
                    c = 0;

                }
                cnt[j][i][0] = c;
            }
        }

        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[j][i] == 0) {
                    c++;
                } else {
                    c = 0;
                }
                cnt[j][i][1] = c;
            }
        }

        return cnt;

    }

    private int[][][] hCnt(int n, int grid[][]) {
        int cnt[][][] = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    c++;
                } else {
                    c = 0;
                }
                cnt[i][j][0] = c;
            }
        }

        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    c++;
                } else {
                    c = 0;
                }
                cnt[i][j][1] = c;
            }
        }

        return cnt;
    }

    private int min(int... arr) {
        return Arrays.stream(arr).min().getAsInt();
    }
}