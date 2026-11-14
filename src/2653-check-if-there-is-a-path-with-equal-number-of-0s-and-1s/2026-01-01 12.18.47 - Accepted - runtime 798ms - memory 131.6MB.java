import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    Set<State> set;
    public boolean isThereAPath(int[][] grid) {
        set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] ==0) grid[i][j] = -1;
            }
        }

        return solve(0, 0, grid, m, n, 0);
    }

    private boolean solve(int i, int j, int grid[][], int m, int n, int total){
        if(i==m-1 && j ==n-1){
            return total + grid[i][j] == 0;
        }
        
        

        if(i>=m || j >=n) return false;
        int newTotal = total + grid[i][j];
        
        State state = new State(i, j, newTotal);
        if(set.contains(state)) return false;
        set.add(state);
        return solve(i+1, j, grid, m, n, newTotal) || solve(i, j+1, grid, m, n, newTotal);
    }

    class State{
        int i, j, sum;

        public State(int i, int j, int sum) {

            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return i == state.i && j == state.j && sum == state.sum;
        }

        @Override
        public int hashCode() {

            return Objects.hash(i, j, sum);
        }
    }


}