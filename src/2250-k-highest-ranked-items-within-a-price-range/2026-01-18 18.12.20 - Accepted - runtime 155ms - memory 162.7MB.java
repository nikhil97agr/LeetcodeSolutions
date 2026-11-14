class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length;
        int n =grid[0].length;

        int dist[][] = new int[m][n];
        boolean vis[][] =new boolean[m][n];
        int dir[] = new int[]{0,1,0,-1,0};
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
            return a[2] - b[2];
        });

        que.offer(new int[]{start[0], start[1], 1});
        vis[start[0]][start[1]] = true;
        dist[start[0]][start[1]] = 1;
        while(!que.isEmpty()){
            int next[] = que.poll();
            int r = next[0];
            int c = next[1];
            int d = next[2];

            for(int i=0;i<4;i++){
                int nr = r + dir[i];
                int nc = c + dir[i+1];

                if(nr < 0 || nc < 0 || nr >=m || nc >= n || vis[nr][nc] || grid[nr][nc] ==0){
                    continue;
                }

                vis[nr][nc] = true;
                dist[nr][nc] = d + 1;
                que.offer(new int[]{nr, nc, d + 1});
            }
        }



        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] <= 1 || grid[i][j] < pricing[0] || grid[i][j] > pricing[1] || dist[i][j] == 0){
                    continue;
                }

                list.add(List.of(i, j));

            }
        }


        list.sort((a,b) ->{
            int i1 = a.get(0), j1 = a.get(1);
            int i2 = b.get(0), j2 = b.get(1);
            int d1 = dist[i1][j1];
            int d2 = dist[i2][j2];
            if(d1!= d2){
                return d1 - d2;
            }

            int p1 = grid[i1][j1];
            int p2 = grid[i2][j2];

            if(p1 !=p2) return p1 - p2;

            if(i1 != i2) return i1 - i2;
            return j1 - j2;

            
        });
        return list.subList(0,Math.min(k, list.size()));

    }
}