class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int max = -1;
        int j = n-1;
        for(int i=n-2;i>=0;i--){
            while( j > i && j - i >= k){
                max = Math.max(max, nums[j]);
                j--;
            }

            if(max != -1){
                ans = Math.max(ans, nums[i] + max);   
            }
        }

        return ans;
    }
}