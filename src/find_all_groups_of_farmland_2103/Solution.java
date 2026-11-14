package find_all_groups_of_farmland_2103;

import java.util.*;
class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        Set<String> vis = new HashSet<>();
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String key = i + ":" + j;
                if (land[i][j] == 1 && !vis.contains(key)) {
                    int res[] = dfs(land, vis, i, j, m, n);
                    ans.add(res);
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    private int[] dfs(int[][] land, Set<String> vis, int i, int j, int m, int n) {
        Stack<int[]> stack = new Stack<>();
        int minX = i;
        int minY = j;
        int maxX = i;
        int maxY = j;

        stack.push(new int[] { i, j });
        vis.add(i + ":" + j);
        while (!stack.isEmpty()) {
            int coord[] = stack.pop();
            int x = coord[0];
            int y = coord[1];

            int dir[] = new int[] { 0, 1, 0, -1, 0 };

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k];
                int ny = y + dir[k + 1];
                String key = nx + ":" + ny;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && land[nx][ny] == 1 && !vis.contains(key)) {
                    minX = Math.min(minX, nx);
                    minY = Math.min(minY, ny);
                    maxX = Math.max(maxX, nx);
                    maxY = Math.max(maxY, ny);
                    stack.push(new int[]{nx, ny});
                    vis.add(key);
                }
            }
        }
        return new int[]{minX, minY, maxX, maxY};
    }
}