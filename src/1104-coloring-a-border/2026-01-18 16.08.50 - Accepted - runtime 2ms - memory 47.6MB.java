class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        boolean border[][] =new boolean[m][n];
        int dir[] = new int[]{0, 1, 0, -1, 0};
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{row, col});
        vis[row][col] = true;
        while(!que.isEmpty()){
            int next[] = que.poll();
            boolean isBorder = false;
            for(int i=0;i<4;i++){
                int nr = next[0] + dir[i];
                int nc = next[1] + dir[i+1];
                if(nr <0 || nc < 0 || nr >= m || nc >= n|| grid[nr][nc] != grid[row][col]){
                    isBorder = true;
                    continue;
                }
                if(!vis[nr][nc]){
                    vis[nr][nc] = true;
                    que.offer(new int[]{nr,nc});
                }
            }
            if(isBorder){
                border[next[0]][next[1]] = true;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(border[i][j]){
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }
}