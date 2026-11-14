class Solution {
    public int containVirus(int[][] isInfected) {
        int m = isInfected.length;
        int n = isInfected[0].length;
        int ans = 0;
        while(true){
            List<Set<Integer>> regions = new ArrayList<>();;
            List<Set<Integer>> frontiers = new ArrayList<>();
            List<Integer> cnt = new ArrayList<>();
            boolean vis[][] = new boolean[m][n];

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    

                    if(!vis[i][j] && isInfected[i][j] == 1){
                        Set<Integer> region = new HashSet<>();
                    Set<Integer> frontier = new HashSet<>();

                   int walls[] = new int[1];

                    dfs(isInfected, vis, i, j, m, n, region, frontier, walls);
                    regions.add(region);
                    frontiers.add(frontier);
                    cnt.add(walls[0]);
                    }

                }
            }

            if(regions.isEmpty()) break;

            int ind = 0;
            for(int i=0;i<regions.size();i++){
                if (frontiers.get(i).size() > frontiers.get(ind).size()) ind = i;
            }

            ans += cnt.get(ind);

            for(int cell: regions.get(ind)){
                int x = cell/n, y = cell%n;
                isInfected[x][y] = -1;
            }   

            for(int i=0;i<regions.size();i++){
                if(i == ind) continue;

                for(int cell : frontiers.get(i)){
                    int x = cell/n, y = cell%n;
                    isInfected[x][y] = 1;
                }
            }
        }

        return ans;
    }

    private void dfs(int grid[][], boolean vis[][], int i, int j, int m, int n, Set<Integer> region, Set<Integer> frontier, int cnt[]){
            vis[i][j] = true;
            region.add(n * i + j);

            int dir[] = new int[]{0,1,0,-1,0};

            for(int d=0;d<4;d++){
                int ni = i + dir[d];
                int nj = j + dir[d+1];

                if(ni < 0 || nj < 0 || ni >= m || nj >= n || vis[ni][nj] ) continue;
                if(grid[ni][nj]==1){
                    dfs(grid, vis, ni, nj, m, n, region, frontier, cnt);
                }else if(grid[ni][nj] == 0){
                    frontier.add(n * ni + nj);
                    cnt[0]++;
                }
            }

    }
}