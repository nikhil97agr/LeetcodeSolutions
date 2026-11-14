class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums) sum +=x;

        if(sum%k!=0) return false;

        int each = sum/ k;
        Boolean dp[][] =new Boolean[k][1<<n];
        return solve(0, k, nums, n, 0, each, dp);
        
    }

    private boolean solve(int i, int k, int nums[], int n,  int finalMask, int each, Boolean dp[][]){

        if(i==k){
            if(finalMask == (1<<n)-1) return true;
            return false;
        }

        if(dp[i][finalMask]!=null) return dp[i][finalMask];

        for(int mask = 1;mask < (1<<n);mask++){
            if((finalMask & mask) ==0){
                if(check(mask, each, nums, n)){
                    if(solve(i+1, k, nums, n, finalMask | mask, each, dp)){
                        return dp[i][finalMask] = true;
                    }
                }
            }
        }
        return dp[i][finalMask] = false;
    }

    private boolean check(int mask, int sum, int nums[], int n){
        for(int i=0;i<n;i++){
            if((mask & (1<<i))!=0){
                sum -= nums[i];
            }
        }

        return sum == 0;
    }

}