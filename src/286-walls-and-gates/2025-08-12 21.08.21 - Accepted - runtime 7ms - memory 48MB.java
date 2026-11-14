class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> que = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0) que.offer(new int[]{i, j, 0});
            }
        }

        while(!que.isEmpty()){
            int next[] = que.poll();
            int dir[] = new int[]{0,1,0,-1,0};
            for(int i=0;i<4;i++){
                int ni = next[0] + dir[i];
                int nj = next[1] + dir[i+1];

                if(ni >=0 && nj >=0 && ni < m && nj < n && rooms[ni][nj] == Integer.MAX_VALUE){
                    rooms[ni][nj] = next[2] + 1;
                    que.offer(new int[]{ni,nj, rooms[ni][nj]}); 
                }
            }
        }
    }
}