package android_unlock_patterns_351;

class Solution {
    int[][] skip = new int[10][10];
    boolean[] used = new boolean[10];

    public int numberOfPatterns(int m, int n) {
        // Define skip conditions
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] =
        skip[2][8] = skip[8][2] =
        skip[3][7] = skip[7][3] =
        skip[4][6] = skip[6][4] = 5;

        int ans = 0;

        // symmetry
        ans += dfs(1, 1, m, n) * 4; // corners
        ans += dfs(2, 1, m, n) * 4; // edges
        ans += dfs(5, 1, m, n);     // center

        return ans;
    }

    private int dfs(int curr, int len, int m, int n) {
        if (len > n) return 0;

        int count = (len >= m) ? 1 : 0;
        used[curr] = true;

        for (int next = 1; next <= 9; next++) {
            int mid = skip[curr][next];
            if (!used[next] && (mid == 0 || used[mid])) {
                count += dfs(next, len + 1, m, n);
            }
        }

        used[curr] = false;
        return count;
    }
}
