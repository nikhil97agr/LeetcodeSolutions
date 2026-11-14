class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        long total = 1l * m * n - (m + n - 1);
        long ans[] = new long[] { total, 0, 0, 0, 0 };
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        for (int c[] : coordinates) {
            map.computeIfAbsent(c[0], x -> new HashSet<>()).add(c[1]);
        }

        for (int c[] : coordinates) {
            int x = c[0];
            int y = c[1];

            update(x, y, ans, map, m, n);
            int dir[][] = new int[][]{
                { -1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1}
            };

            for(int d[] : dir){
                int nx= x + d[0];
                int ny = y + d[1];
                if(valid(nx, ny ,m ,n ) && check(nx, ny, map) == 0 &&  check(nx, ny, visited) == 0){
                    update(nx, ny, ans, map, m , n);
                    visited.computeIfAbsent(nx, x1-> new HashSet<>()).add(ny);
                }
            }
        }

        return ans;
    }

    public void update(int x, int y, long ans[], Map<Integer, Set<Integer>> map, int m, int n) {
        if (!valid(x, y, m, n))
            return;
        int cnt = check(x, y, map) + check(x + 1, y, map) + check(x, y + 1, map) + check(x + 1, y + 1, map);

        ans[0]--;
        ans[cnt]++;
    }

    private int check(int x, int y, Map<Integer, Set<Integer>> map) {
        if (map.containsKey(x) && map.get(x).contains(y))
            return 1;
        return 0;
    }

    private boolean valid(int x, int y, int m, int n) {
        return x < m - 1 && y < n - 1  && x >=0 && y >=0;
    }
}