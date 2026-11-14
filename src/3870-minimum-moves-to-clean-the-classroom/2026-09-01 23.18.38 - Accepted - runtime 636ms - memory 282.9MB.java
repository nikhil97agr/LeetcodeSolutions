import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int minMoves(String[] classroom, int maxEnergy) {
        int n = classroom.length;
        int m = classroom[0].length();

        char grid[][] = grid(classroom, n, m);
        Queue<State> que = new LinkedList<>();
        int l=0;
        int r=0;
        int c=0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 'S'){
                    r = i;
                    c = j;
                }else if(grid[i][j] == 'L'){
                    map.put(i+":"+j, l);
                    l++;
                }
            }
        }
        int finalState = (1<<l)-1;
        que.offer(new State(r,c, 0, 0, maxEnergy));
        boolean visited[][][][] = new boolean[n][m][maxEnergy + 1][finalState + 1];
        visited[r][c][maxEnergy][0] = true;
        while(!que.isEmpty()){
            State state = que.poll();

            if(state.state == finalState){
                return state.moves;
            }

            int moves = state.moves;
            int currState = state.state;
            r = state.r;
            c = state.c;
            int energy = state.energy;

            int dir[] = new int[]{0,1,0,-1, 0};

            for(int i=0;i<4;i++){
                int nr = r + dir[i];
                int nc = c + dir[i+1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m ) continue;

                int newEnergy = energy - 1;
                if(newEnergy < 0) continue;

                char ch = grid[nr][nc];

                if(ch == 'X') continue;

                if(ch == 'R') newEnergy = maxEnergy;
                int newState = currState;
                if(ch == 'L'){
                    int val = map.get(nr+":"+nc);
                    newState = newState | (1<<val);

                }


                if(!visited[nr][nc][newEnergy][newState]){
                    visited[nr][nc][newEnergy][newState] = true;
                    que.offer(new State(nr, nc, moves+1, newState, newEnergy));
                }


            }

        }

        return -1;
    }

    private char[][] grid(String[] classroom, int n, int m) {
        char grid[][] = new char[n][m];
        for(int i=0;i<n;i++){
            grid[i] =classroom[i].toCharArray();
        }


        return grid;
    }


    class State{
        int r;
        int c;
        int moves;
        int state;
        int energy;

        public State(int r, int c, int moves, int state, int energy) {
            this.r = r;
            this.c = c;
            this.moves = moves;
            this.state = state;
            this.energy = energy;
        }
    }
}