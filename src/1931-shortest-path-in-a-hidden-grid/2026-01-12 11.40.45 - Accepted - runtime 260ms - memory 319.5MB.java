/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     void move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
        int m = 500;

    public int findShortestPath(GridMaster master) {
        Status status[][] = new Status[m*2][m*2];
        for(int i=0;i<m*2;i++){
            for(int j=0;j<m*2;j++){
                status[i][j] = Status.idle;
            }
        }

        status[m][m] = Status.start;
        int target[] = dfs(m, m, status, master);
        if(target == null) return -1;

        return bfs(status, master, target[0], target[1])+1;
    }

    private int bfs(Status status[][], GridMaster master, int r, int c){
        int dist = 0;

        Queue<int[]> que= new LinkedList<>();
        que.offer(new int[]{r,c});
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int next[] = que.poll();
                r = next[0];
                c = next[1];
                for(Direction d: Direction.values()){
                    int nr = r + d.r;
                    int nc = c + d.c;
                    if(nr >= 2*m || nc >= 2*m || nr < 0 || nc< 0) continue;
                    if(status[nr][nc] == Status.start) return dist;

                    if(status[nr][nc] != Status.path) continue;

                    status[nr][nc]= Status.blocked;

                    que.offer(new int[]{nr, nc});
                }
            }
            dist++;
        }

        return -1;
    }

    private int[] dfs(int r, int c,Status status[][], GridMaster master){
        if(master.isTarget()){
            status[r][c] = Status.target;
            return new int[]{r, c};
        }

        int target[] = null;
        for(Direction d : Direction.values()){
            int nr = r + d.r;
            int nc = c + d.c;

            if(nr <2*m && nc <2*m &&status[nr][nc] == Status.idle){
                if( master.canMove(d.next)){
                    status[nr][nc] = Status.path;
                    master.move(d.next);
                    
                    int next[] = dfs(nr, nc, status, master);
                    if(next !=null){
                        target = next;
                    }
                    master.move(d.prev);

                }else{
                    status[nr][nc] = Status.blocked;
                }
            }
        }

        return target;
    }

    enum Status{
        idle,
        start,
        target,
        path,
        blocked
    }

    enum Direction{
        UP('U', 'D', 0, -1),
        DOWN('D', 'U', 0, 1),
        LEFT('L' ,'R', -1, 0),
        RIGHT('R', 'L', 1, 0);

        char next;
        char prev;
        int r;
        int c;
        Direction(char next, char prev, int i, int j){
            this.next = next;
            this.prev = prev;
            this.r = i;
            this.c = j;
        }
    }
}