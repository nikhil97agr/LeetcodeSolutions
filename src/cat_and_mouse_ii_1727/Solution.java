package cat_and_mouse_ii_1727;

import java.util.*;
class Solution {
    class State{
        int cx;
        int cy;
        int mx;
        int my;
        int turn;

        public State(int cx, int cy, int mx, int my, int turn){
            this.cx =cx;
            this.cy = cy;
            this.mx = mx;
            this.my = my;
            this.turn = turn;
        }

        public int hashCode(){
            return (""+cx+":"+cy+":"+mx+":"+my+":"+turn).hashCode();
        }
        public boolean equals(Object obj){
            State state = (State)obj;

            return (state.cx ==cx && state.cy == cy && state.mx ==mx && state.my == my && state.turn==turn);
        }
    }
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int mouse[] = null;
        int cat[] = null;
        int food[] = null;
        Map<State, Boolean> dp = new HashMap<>();
        int n =grid.length;
        int m = grid[0].length();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i].charAt(j)=='C'){
                    cat =new int[] {i,j};
                }
                if(grid[i].charAt(j)=='F'){
                    food = new int[]{i,j};
                }
                if(grid[i].charAt(j)=='M'){
                    mouse = new int[]{i,j};
                }
            }
        }

        return solve(grid, catJump, mouseJump, 0, cat, mouse, food, n,m, dp);
    }

    private boolean solve(String grid[], int catJump, int mouseJump, int turn, int cat[], int mouse[], int food[],int n, int m, Map<State, Boolean> dp){
        if(Arrays.equals(cat, mouse) || Arrays.equals(cat, food) || turn>=75) return false;

        if(Arrays.equals(mouse, food)) return true;
        State state = new State(cat[0], cat[1], mouse[0], mouse[1], turn);

        if(dp.containsKey(state)) return dp.get(state);
        int move[][] = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        if(turn%2==0){
            for(int mv[] : move){
                for(int points[] : getNextMoves(mv, mouse, mouseJump, grid, n, m)){
                    if(solve(grid, catJump, mouseJump, turn+1, cat, points, food, n, m, dp)) {
                        dp.put(state, true);
                        return true;
                    }
                }
            }
            dp.put(state, false);
            return false;
        }else{
            for(int mv[] : move){
                for(int point[] : getNextMoves(mv, cat, catJump, grid, n, m)){
                    if(!solve(grid, catJump, mouseJump, turn+1, point, mouse, food, n, m ,dp)){
                        dp.put(state, false);
                        return false;
                     }
                }

                
            }
            dp.put(state, true);
            return true;
        }
    }

    private List<int[]> getNextMoves(int moves[], int mouse[], int mouseJump,String grid[], int n, int m){
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<=mouseJump;i++){
            int nx = mouse[0]+moves[0]*i;
            int ny = mouse[1] + moves[1]*i;
            if(nx >=0 && nx<n && ny>=0 && ny<m && grid[nx].charAt(ny)!='#'){
                result.add(new int[]{nx, ny});
            }else{
                return result;
            }
        }
        return result;
    }
}