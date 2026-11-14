class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        Integer dp[][] = new Integer[n][1<<n];

        return solve(nums, 0, dp, n, 0, k);
    }

    private int solve(int nums[], int ind, Integer dp[][], int n, int currState, int k){

        if(ind == n){
            if(currState != 0) return 1;
            return 0;
        }
        if(dp[ind][currState] !=null) return dp[ind][currState];


        int ans = 0;

        boolean possible =  true;

        for(int i=0;i<n;i++){
            if((currState&(1<<i)) != 0 && Math.abs(nums[i] - nums[ind])== k){
                possible = false;
                break;
            }
        }

        if(possible){
            ans += solve(nums, ind+1, dp, n, currState | (1<<ind), k);
        }

        ans += solve(nums, ind+1, dp, n, currState, k);

        return dp[ind][currState] = ans;




    }
}