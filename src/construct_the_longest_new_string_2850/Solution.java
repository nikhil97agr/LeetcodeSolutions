package construct_the_longest_new_string_2850;

class Solution {
    Integer dp[][][][];
    public int longestString(int x, int y, int z) {
        dp = new Integer[x+1][y+1][z+1][4];
        return solve(x, y, z, 3);
    }

    private int solve(int x, int y, int z, int turn){
        if(dp[x][y][z][turn]!=null) return dp[x][y][z][turn];
        int ans = 0;
        if(x!=0){
            if(turn != 0){
                ans = Math.max(ans, 2 + solve(x-1, y, z, 0));
            }
        }

        if(y!=0){
            if(turn !=1 && turn !=2){
                ans = Math.max(ans, 2 + solve(x, y-1, z, 1));
            }
        }

        if(z!=0){
            if(turn !=0){
                ans = Math.max(ans, 2 + solve(x, y, z-1, 2));
            }
        }

        return dp[x][y][z][turn] = ans;
    }
}