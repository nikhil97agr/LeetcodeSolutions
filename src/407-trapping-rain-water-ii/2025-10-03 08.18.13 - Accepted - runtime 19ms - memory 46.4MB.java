class Solution {
    class Cell{
        int x;
        int y;
        int height;
        public Cell(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
    public int trapRainWater(int[][] height) {
        int n = height.length;
        int m = height[0].length;
        boolean visited[][] =new boolean[n][m];
        PriorityQueue<Cell> que = new PriorityQueue<>((a,b)->{
            return a.height - b.height;
        });
        for(int i=0;i<n;i++){
            if(!visited[i][0]){
                que.add(new Cell(i, 0, height[i][0]));
                visited[i][0] = true;
            }
            if(!visited[i][m-1]){
                que.add(new Cell(i, m-1, height[i][m-1]));
                visited[i][m-1] = true;
            }
        }

        for(int i=0;i<m;i++){
            if(!visited[0][i]){
                que.add(new Cell(0, i, height[0][i]));
                visited[0][i] = true;
            }

            if(!visited[n-1][i]){
                que.add(new Cell(n-1, i, height[n-1][i]));
                visited[n-1][i] = true;
            }
        }

        int ans = 0;
        while(!que.isEmpty()){
            Cell cell = que.poll();

            int dir[] = new int[]{0, 1, 0, -1, 0};

            for(int i=0;i<4;i++){
                int nx = cell.x + dir[i];
                int ny = cell.y + dir[i+1];

                if(nx >0 && ny>0 && nx < n-1 && ny < m-1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(height[nx][ny] > cell.height){
                        que.add(new Cell(nx, ny, height[nx][ny]));
                    }else{
                        ans += (cell.height - height[nx][ny]);
                        que.add(new Cell(nx, ny, cell.height));
                    }
                }
            }
        }

        return ans;
    }
}