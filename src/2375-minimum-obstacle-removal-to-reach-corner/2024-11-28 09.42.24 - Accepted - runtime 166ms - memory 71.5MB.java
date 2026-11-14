class Solution {
    class Cell{
        int i;
        int j;
        int isObstacle;
        int obsRemoved;
        public Cell(int i, int j, int isObstacle){
            this.i = i;
            this.j = j;
            this.isObstacle = isObstacle;
        }

        public String toString(){
            return ""+i+":"+j+":"+isObstacle+":"+obsRemoved;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Cell> que = new PriorityQueue<Cell>((a,b)->{
            if(a.isObstacle==0&&b.isObstacle==1){
                return -1;
            }
            if(a.isObstacle ==1&& b.isObstacle==0){
                return 1;
            }
            return a.obsRemoved - b.obsRemoved;
        });
        Cell cell = new Cell(0,0,0);
        cell.obsRemoved = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {-1,1,0,0};
        que.add(cell);
        boolean visited[][] = new boolean[m][n];
        visited[0][0] = true;
        while(!que.isEmpty()){
            cell = que.poll();
            if(cell.i == m-1 && cell.j == n-1){
                return cell.obsRemoved;
            }
            int x = cell.i;
            int y = cell.j;
        
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=m || ny>=n || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                Cell temp = new Cell(nx, ny,grid[nx][ny]);
                if(temp.isObstacle==1){
                    temp.obsRemoved = cell.obsRemoved + 1;
                }else{
                    temp.obsRemoved = cell.obsRemoved;
                }
                que.add(temp);
            }

        }
        return 0;
    }
}