class Solution {
    public int twoEggDrop(int n) {
        int eggs = 2;
        Integer dp[][] = new Integer[n+1][3];
        return solve(n, 2, dp);
    }

    private int solve(int floor, int eggs, Integer dp[][]){
        if(eggs == 1) return floor;
        if(floor<=1)return floor;

        if(dp[floor][eggs]!=null) return dp[floor][eggs];
        int ans= Integer.MAX_VALUE;
        int start = 1;
        int end = floor;
        while(start <= end){
            int mid = (start+end)/2;
            int broken = solve(mid-1, eggs-1, dp);
            int not = solve(floor-mid, eggs, dp);

            ans = Math.min(ans, Math.max(broken, not)+1);

            if(broken > not){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return dp[floor][eggs] = ans;
    }
}