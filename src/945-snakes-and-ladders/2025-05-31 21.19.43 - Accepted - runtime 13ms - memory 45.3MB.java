import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        boolean vis[][] =new boolean[n][n];
        Map<Integer, int[]> map = new HashMap<>();
        boolean inc = true;
        int next = 1;
        for(int i=n-1;i>=0;i--){
            if(inc){
                for(int j=0;j<n;j++){
                    map.put(next, new int[]{i,j});
                    next++;
                }
            }else{
                for(int j=n-1;j>=0;j--){
                    map.put(next, new int[]{i, j});
                    next++;
                }
            }
            inc = !inc;
        }

        PriorityQueue<Move> que = new PriorityQueue<>((m1,m2)-> m1.steps -  m2.steps);

        que.offer(new Move(1, 0));
        vis[n-1][0] =true;
        while(!que.isEmpty()){
            Move move = que.poll();

            int pos[] = map.get(move.value);

            if(move.value == n*n){
                return move.steps;
            }

            int val = move.value;
            int steps = move.steps;

            for(int i=val+1;i<=Math.min(val + 6, n*n);i++){
                int p[] = map.get(i);
                 next = board[p[0]][p[1]];
                if(!vis[p[0]][p[1]]){
                    vis[p[0]][p[1]] = true;
                    que.offer(new Move(next!=-1 ? next: i, steps+1));
                }
            }
        }


        return -1;
    }

    class Move{
        int value;

        int steps;

        public Move(int value, int steps){
            this.value = value;
            this.steps = steps;
        }
    }
}