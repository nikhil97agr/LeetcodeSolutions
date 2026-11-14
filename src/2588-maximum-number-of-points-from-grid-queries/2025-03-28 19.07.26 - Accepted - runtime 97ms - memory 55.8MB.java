class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int r = grid.length;
        int c= grid[0].length;
        int k = queries.length;
        int res[] = new int[k];
        int sorted[][] = new int[k][2];
        for(int i=0;i<k;i++){
            sorted[i][0] = queries[i];
            sorted[i][1] = i;
        }

        Arrays.sort(sorted, (a,b)-> a[0] - b[0]);

        PriorityQueue<Node> que = new PriorityQueue<>((a,b) -> a.val - b.val);
        que.offer(new Node(0, 0, grid[0][0]));
        int cnt = 0;
        boolean vis[][] = new boolean[r][c];
        vis[0][0] = true;
        for(int q[] : sorted){
            int val = q[0];
            int ind = q[1];
            int dir[][] = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
            while(!que.isEmpty() && que.peek().val < val){
                Node node =que.poll();
                cnt++;
                for(int d[] : dir){
                    int nr = node.r + d[0];
                    int nc = node.c + d[1];

                    if(nr >=0 && nc >=0 && nr < r && nc < c && !vis[nr][nc]){
                        que.offer(new Node(nr, nc, grid[nr][nc]));
                        vis[nr][nc] = true;
                    }
                }
            }

            res[ind] = cnt;
        }


        return res;
    }

    class Node{
        int r;
        int c;
        int val;

        public Node(int r, int c, int val){
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
}