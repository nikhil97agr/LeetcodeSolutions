class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int arr[] = new int[2*numSlots];
        for(int i=0;i<Math.min(nums.length, arr.length); i++){
            arr[i] = nums[i];
        }
        numSlots  = arr.length;
        int finalState = (1<<numSlots)-1;
        Integer dp[]= new Integer[finalState+1];
        return solve(arr, 0, 0, finalState, dp);
    }

    private int solve(int arr[], int currState, int slotIndex, int finalState, Integer dp[]){
        if(currState == finalState){
            return 0;
        }

        if(dp[currState]!=null) return dp[currState];
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if((currState &(1<<i))==0)
            ans = Math.max(ans, (arr[i]&(slotIndex/2+1)) + solve(arr, currState | (1<<i), slotIndex+1, finalState, dp));


        }

        return dp[currState]=ans;
    }
}