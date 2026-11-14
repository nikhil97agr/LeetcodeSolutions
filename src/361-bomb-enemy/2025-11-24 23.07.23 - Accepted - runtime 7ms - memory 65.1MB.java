class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int c[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    cnt = 0;
                    continue;
                }
                if (grid[i][j] == 'E') {
                    cnt++;
                    continue;
                }

                c[i][j] += cnt;
            }
            cnt = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    cnt = 0;
                    continue;
                }
                if (grid[i][j] == 'E') {
                    cnt++;
                    continue;
                }

                c[i][j] += cnt;
            }
        }

        for (int j=0;j<n;j++) {
            int cnt = 0;
            for (int i=0;i<m;i++) {
                if (grid[i][j] == 'W') {
                    cnt = 0;
                    continue;
                }
                if (grid[i][j] == 'E') {
                    cnt++;
                    continue;
                }

                c[i][j] += cnt;
            }
            cnt = 0;

            for (int i=m-1;i>=0;i--) {
                if (grid[i][j] == 'W') {
                    cnt = 0;
                    continue;
                }
                if (grid[i][j] == 'E') {
                    cnt++;
                    continue;
                }

                c[i][j] += cnt;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    ans = Math.max(ans, c[i][j]);
                }
            }
        }

        return ans;
    }
}