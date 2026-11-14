class Solution {
    public int largestIsland(int[][] grid) {
        int grp = 0;
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        boolean vis[][] = new boolean[m][n]; 
        int grpMap[][] = new int[m][n];
        for(int g[]: grpMap){
            Arrays.fill(g, -1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] !=0 && !vis[i][j]){
                    int cnt = bfs(i, j, grid, m, n, vis, grp, grpMap);
                    map.put(grp, cnt);
                    grp++;
                }
            }
        }
        int ans = map.values().stream().max(Integer::compareTo).orElse(0);
        int dir[][] = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==0 ){
                    int total =0;
                    Map<Integer, Integer> temp = new HashMap<>();
                    for(int d[] :dir){
                        int ni = i+d[0];
                        int nj = j+d[1];
                        int cnt[] = getCnt(ni, nj, grpMap, m, n, map);
                        int def = temp.getOrDefault(cnt[1], 0);
                        temp.put(cnt[1], Math.max(cnt[0], def));
                    }
                    ans = Math.max(ans, 1 + temp.values().stream().reduce(0, Integer::sum));
 
                }
            }
        }
        return ans;
    }

    private int[] getCnt(int i, int j, int grpMap[][], int m, int n, Map<Integer, Integer> map){
        if(i <0 || j < 0 || i>=m || j>=n || grpMap[i][j] == -1) return new int[] {0, -1};
        return new int[]{map.get(grpMap[i][j]), grpMap[i][j]};
    }

    private int bfs(int i, int j, int grid[][], int m, int n, boolean vis[][], int grp, int grpMap[][]){
        if(i < 0 || j < 0|| i>=m || j >= n|| grid[i][j] ==0 || vis[i][j]) return 0;

        vis[i][j] = true;
        grpMap[i][j] = grp;
        int cnt = 1 + bfs(i+1, j, grid, m, n, vis, grp, grpMap) + bfs(i, j+1, grid, m, n, vis, grp, grpMap) + bfs(i -1 ,j, grid, m, n, vis, grp, grpMap) + bfs(i, j-1, grid, m, n, vis, grp, grpMap);
        return cnt;
    }
}