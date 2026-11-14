package maximum_number_of_accepted_invitations_1969;

import java.util.*;
class Solution {
    public int maximumInvitations(int[][] grid) {
        int girlMatch[] = new int[grid[0].length];
        int m = grid[0].length;
        int n = grid.length;
        Arrays.fill(girlMatch, -1);
        for(int i=0;i<n;i++){
            dfs(i, grid, girlMatch, new boolean[n]);
        }
        return (int)Arrays.stream(girlMatch).filter(x -> x != -1).count();
    }

    private boolean dfs(int curr, int grid[][], int girls[], boolean vis[]){
        if(vis[curr]) return false;
        vis[curr] =true;
        for(int i=0;i<girls.length;i++){
            if(grid[curr][i] ==0) continue;

            if(girls[i] != -1 && !dfs(girls[i], grid, girls, vis)) continue;
            girls[i] = curr;
            return true;
        }
        return false;
    }

}