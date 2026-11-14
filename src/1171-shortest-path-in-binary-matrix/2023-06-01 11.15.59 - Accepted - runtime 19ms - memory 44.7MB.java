class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0, 1});
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int di[] = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int dj[] = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        visited[0][0] = true;
        while(!que.isEmpty()){
            int []cell = que.poll();
            if(cell[0]==n-1 && cell[1]==n-1){
                return cell[2];
            }
            for(int i=0;i<8;i++){
                int ni = cell[0] + di[i];
                int nj = cell[1] + dj[i];

                if(isSafe(ni, nj, n, visited, grid)){
                    que.add(new int[]{ni, nj, cell[2]+1});
                    visited[ni][nj] = true;
                }
            }
        }
        return -1;

    }

    private boolean isSafe(int i, int j, int n, boolean visited[][], int grid[][]){
        return (i>=0) && (i<n) && (j>=0) && (j<n )&& (!visited[i][j]) && (grid[i][j]==0);
        
        
    }
}