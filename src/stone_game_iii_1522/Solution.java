package stone_game_iii_1522;

class Solution {
    public String stoneGameIII(int[] stones) {
        int n = stones.length;
        Integer dp[] = new Integer[n];

        solve(stones, 0, dp, n);
        if(dp[0]==0) return "Tie";
        if(dp[0]>0) return "Alice";
        return "Bob";
    }

    private int solve(int stones[], int ind, Integer dp[], int n){
        if(ind>=n){
            return 0;
        }

        if(dp[ind]!=null){
            return dp[ind];
        }

        int ans = stones[ind] - solve(stones, ind+1, dp, n);
        if(ind+1<n){
            ans = max(ans, stones[ind]+stones[ind+1] - solve(stones, ind+2, dp, n));

        }
        if(ind+2<n){
            ans = max(ans, stones[ind] + stones[ind+1]+stones[ind+2] - solve(stones, ind+3, dp ,n));

        }

        return dp[ind] = ans;
    }

    private int max(int first, int second){
        if(first==second){
            return first;
        }
        if(first>second){
            return first;
        }

        return second;
    }
}