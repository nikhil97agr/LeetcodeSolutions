class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][2];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
            dp[i][0] = sum;
            if(sum < 0){
                sum = 0;
            }
        }

        dp[0][1] = nums[0]*nums[0];
        for(int i=1;i<n;i++){
            dp[i][1] = max(
                dp[i-1][0] + nums[i] * nums[i],
                dp[i-1][1] + nums[i],
                nums[i] * nums[i]
            );
        }

        

        return Arrays.stream(dp).map(x-> x[1]).max(Integer::compareTo).get();
    }

    private int max(int...arr){
        return Arrays.stream(arr).max().getAsInt();
    }
}