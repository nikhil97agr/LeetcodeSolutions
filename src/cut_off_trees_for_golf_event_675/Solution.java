package cut_off_trees_for_golf_event_675;

import java.util.*;

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        int m = forest.get(0).size();

        // Collect all trees
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }

        // Sort by height
        Collections.sort(trees, (a, b) -> a[0] - b[0]);

        int sr = 0, sc = 0;
        int ans = 0;

        // BFS between consecutive trees
        for (int[] tree : trees) {
            int tr = tree[1];
            int tc = tree[2];

            int dist = bfs(forest, sr, sc, tr, tc);
            if (dist == -1) return -1;

            ans += dist;
            sr = tr;
            sc = tc;
        }

        return ans;
    }

    private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        if (sr == tr && sc == tc) return 0;

        int n = forest.size();
        int m = forest.get(0).size();

        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        vis[sr][sc] = true;

        int[] dir = {0, 1, 0, -1, 0};
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];

                if (i == tr && j == tc) return steps;

                for (int d = 0; d < 4; d++) {
                    int ni = i + dir[d];
                    int nj = j + dir[d + 1];

                    if (ni >= 0 && nj >= 0 && ni < n && nj < m &&
                        !vis[ni][nj] && forest.get(ni).get(nj) != 0) {
                        vis[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
