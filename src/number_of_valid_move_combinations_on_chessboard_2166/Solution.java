package number_of_valid_move_combinations_on_chessboard_2166;

import java.util.*;
class Solution {

    // directions: rook, bishop, queen
    private static final int[][] ROOK = {{1,0},{-1,0},{0,1},{0,-1}};
    private static final int[][] BISHOP = {{1,1},{1,-1},{-1,1},{-1,-1}};
    private static final int[][] QUEEN = {
        {1,0},{-1,0},{0,1},{0,-1},
        {1,1},{1,-1},{-1,1},{-1,-1}
    };

    int ans = 0;

    public int countCombinations(String[] pieces, int[][] positions) {
        dfs(0, pieces, positions, new ArrayList<>());
        return ans;
    }

    private void dfs(int idx, String[] pieces, int[][] positions,
                     List<List<int[]>> paths) {

        if (idx == pieces.length) {
            if (valid(paths)) ans++;
            return;
        }

        int[][] dirs = getDirs(pieces[idx]);
        int x = positions[idx][0];
        int y = positions[idx][1];

        // option 1: don't move
        List<int[]> stay = new ArrayList<>();
        stay.add(new int[]{x, y});
        paths.add(stay);
        dfs(idx + 1, pieces, positions, paths);
        paths.remove(paths.size() - 1);

        // option 2: move in directions
        for (int[] d : dirs) {
            int nx = x, ny = y;
            List<int[]> path = new ArrayList<>();
            path.add(new int[]{x, y});

            for (int step = 1; step <= 8; step++) {
                nx += d[0];
                ny += d[1];
                if (nx < 1 || nx > 8 || ny < 1 || ny > 8) break;

                path.add(new int[]{nx, ny});
                paths.add(path);
                dfs(idx + 1, pieces, positions, paths);
                paths.remove(paths.size() - 1);
            }
        }
    }

    private boolean valid(List<List<int[]>> paths) {
        int maxT = 0;
        for (List<int[]> p : paths) maxT = Math.max(maxT, p.size());

        for (int t = 0; t < maxT; t++) {
            boolean[][] vis = new boolean[9][9];
            for (List<int[]> p : paths) {
                int[] pos = t < p.size() ? p.get(t) : p.get(p.size() - 1);
                if (vis[pos[0]][pos[1]]) return false;
                vis[pos[0]][pos[1]] = true;
            }
        }
        return true;
    }

    private int[][] getDirs(String piece) {
        if (piece.equals("rook")) return ROOK;
        if (piece.equals("bishop")) return BISHOP;
        return QUEEN;
    }
}
