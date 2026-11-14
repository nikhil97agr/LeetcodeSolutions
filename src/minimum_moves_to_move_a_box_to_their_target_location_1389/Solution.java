package minimum_moves_to_move_a_box_to_their_target_location_1389;

import java.util.*;
class Solution {
    class State{
        int sb;
        int eb;
        int ss;
        int es;
        public State(int bstart, int bend, int sstart, int send){
            this.sb = bstart;
            this.eb = bend;
            this.ss = sstart;
            this.es = send;
        }

        public int hashCode(){
            return (""+sb+":"+eb+":"+ss +":"+es).hashCode();
        }

        public boolean equals(Object s){
            State state = (State)s;
            return state.eb == eb && state.sb == sb && state.ss == ss && state.es == es;
        }
    }
    public int minPushBox(char[][] grid) {
        Queue<State> que = new LinkedList<>();

        int ans = Integer.MAX_VALUE;

        int start[] = null;
        int end[] = null;
        int box[] = null;

        int n =grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 'B'){
                    box = new int[]{i,j};
                }
                if(grid[i][j]=='T'){
                    end = new int[]{i,j};
                }

                if(grid[i][j]=='S'){
                    start = new int[]{i,j};
                }
            }
        }

        Map<State, Integer> map = new HashMap<>();
        State curr = new State(box[0], box[1], start[0], start[1]);
        map.put(curr, 0);

        que.offer(curr);


        int moves[][] = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        while(!que.isEmpty()){
            curr = que.poll();
            

            if(map.get(curr) >= ans) continue;

            if(curr.sb==end[0] && curr.eb == end[1]){
                ans = Math.min(ans, map.get(curr));
                continue;
            }
            for(int move[] : moves){
                int nss = curr.ss + move[0];
                int nes = curr.es + move[1];

                if(isValid(n, m, grid, nss, nes)){
                    if(nss==curr.sb && nes==curr.eb){
                        int nsb = curr.sb+move[0];
                        int neb = curr.eb + move[1];
                        if(isValid(n, m, grid, nsb, neb)){
                            
                                State state = new State(nsb, neb, nss, nes);
                                if(map.containsKey(state) && map.get(state) <= map.get(curr)+1 ) continue;
                                map.put(state, map.get(curr)+1);
                                que.offer(state);
                        }
                    }else{
                        State state = new State(curr.sb, curr.eb, nss, nes);
                        if(map.containsKey(state) && map.get(state) <= map.get(curr)) continue;

                        map.put(state, map.get(curr));
                        que.add(state);
                    }
                } 
            }
        }

        return( (ans == Integer.MAX_VALUE) ? -1 : ans);
    }

    private boolean isValid(int n, int m, char grid[][], int x, int y){
        return !(x<0 || y<0 || x>=n || y>=m || grid[x][y]=='#');
    }
}