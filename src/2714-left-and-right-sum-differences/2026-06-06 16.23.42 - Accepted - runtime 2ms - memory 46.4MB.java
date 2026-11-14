class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int right[] = new int[n];
        int ans[] = new int[n];


        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] + nums[i+1];
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            ans[i] =  Math.abs(sum - right[i]);
            sum += nums[i];
        }
        return ans;
    }
}