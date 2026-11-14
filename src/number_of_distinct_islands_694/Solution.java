package number_of_distinct_islands_694;

import java.util.*;
class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> hash = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    vis[i][j] = true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    List<int[]> list = new ArrayList<>();
                    dfs(grid, list, i, j, n, m, vis);
                    String process = process(list, n, m);
                    hash.add(process);
                }
            }


        }

        return hash.size();
    }

    private String process(List<int[]> list, int n, int m){
        int minn = n, maxn = 0, minm = m, maxm = 0;
        for(int i[] : list){
            minn = Math.min(minn, i[0]);
            maxn = Math.max(maxn, i[0]);
            minm = Math.min(minm, i[1]);
            maxm = Math.max(maxm, i[1]);
        }
        
        List<int[]> vals = new ArrayList<>();
        for(int l[] : list){
            int i = l[0] - minn;
            int j = l[1] - minm;
            vals.add(new int[]{i,j});
        }

        Collections.sort(vals, (a,b) ->{
            if(a[0] == b[0]) return a[1] -b[1];

            return a[0] - b[0];
        });
        StringBuilder sb = new StringBuilder();
        for(int ind[] : vals){
            sb.append("("+ind[0]+","+ind[1]+")");
        }

        return sb.toString();
    }

    private void dfs(int grid[][], List<int[]> list, int i, int j, int n, int m, boolean vis[][]){
        if(i  < 0 || j < 0 || i >=n || j >=m || vis[i][j]) return;

        vis[i][j] = true;
        list.add(new int[]{i, j});
        int dir[][] = new int[][]{{0, 1}, {1,0}, {0,-1}, {-1, 0}};

        for(int d[] : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            dfs(grid, list, ni, nj, n, m, vis);
        }
    }
}