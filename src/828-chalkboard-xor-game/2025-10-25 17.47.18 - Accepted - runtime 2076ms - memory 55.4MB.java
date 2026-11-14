class Solution {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        Boolean dp[][]= new Boolean[(int)Math.pow(2,16)][2];
        for(int x : nums) xor ^= x;

        return solve(0, nums, nums.length, xor, dp);
    }

    private boolean solve(int turn, int nums[], int n, int xor, Boolean dp[][]){
        if(xor ==0){
            return turn == 0;
        }

        if(dp[xor][turn] != null) return dp[xor][turn];


            for(int i=0;i<n;i++){
                if(nums[i] != -1){
                    int val = nums[i];
                    nums[i] = -1;

                    boolean res= solve(turn ^1, nums, n, xor ^ val, dp);
                    if(turn ==0 && res){
                        nums[i] = val;
                        return dp[xor][turn]= true;
                    }

                    if(turn == 1 && !res){
                        nums[i] = val;
                        return dp[xor][turn] = false;
                    }
                    nums[i] = val;
                }
            }

            return dp[xor][turn] = turn != 0;
        

       


    
    }
}