package maximum_number_of_moves_to_kill_all_pawns_3560;

import java.util.*;
class Solution {
    public int maxMoves(int kx, int ky, int[][] positions) {
        int n = positions.length;
        int pos[][] = new int[n+1][];
        pos[0] = new int[]{kx, ky};
        for(int i=1;i<=n;i++){
            pos[i] = positions[i-1];
        }
        n++;
        Integer dp[][][] = new Integer[n][1<<n][2];
        int dist[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            int x = pos[i][0];
            int y = pos[i][1];
            for(int j=i+1;j<n;j++){
                int x1 = pos[j][0];
                int y1 = pos[j][1];
                dist[i][j] = dist[j][i] = turns(x, y, x1, y1);
            }
        }
        return solve(1, (1<<n)-1, 0, pos, n, 1, dp, dist);
    }

    private int solve(int state, int finalState,int prev, int positions[][], int n, int t, Integer dp[][][], int dist[][]){
        if(state == finalState){
            return 0;
        }

        if(dp[prev][state][t] !=null) return dp[prev][state][t];
        int x = positions[prev][0];
        int y = positions[prev][1];
        if(t == 1){
            int ans = Integer.MIN_VALUE;

            for(int i=0;i<n;i++){
                if((state & (1<<i))==0){
                    int turn = dist[prev][i];
                    
                    ans = Math.max(ans, turn + solve(state | (1<<i), finalState, i, positions, n, 0, dp, dist));
                }
            }
            return dp[prev][state][t] = ans;
        }else{
            int ans = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if((state & (1<<i))==0){
                    int turn = dist[prev][i];
                    ans = Math.min(ans, turn +solve(state | (1<<i), finalState,i, positions, n, 1, dp, dist));
                }
            }
            return dp[prev][state][t] = ans;
        }
    }

    private int turns(int x1, int y1, int x2, int y2){
        int cnt = 0;
        boolean vis[][] = new boolean[50][50];

        Queue<int[]> que  = new LinkedList<>();
        que.offer(new int[]{x1,y1});
        vis[x1][y1] = true;
        int dir[][] = new int[][] {
            {1,2}, {2,1}, {2,-1}, {1, -2},
            {-1,2}, {-2,1}, {-2,-1}, {-1,-2}
        };
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- >0){
                int next[] = que.poll();
                int x = next[0];
                int y = next[1];
                if(x == x2 && y == y2) return cnt;
                for(int d[] : dir){
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if(nx < 0 || ny < 0 || nx >= 50 || ny >= 50 || vis[nx][ny]) continue;

                    vis[nx][ny] = true;
                    que.offer(new int[]{nx, ny});
                }

            }
            cnt++;
        }

        return -1;
    }
}