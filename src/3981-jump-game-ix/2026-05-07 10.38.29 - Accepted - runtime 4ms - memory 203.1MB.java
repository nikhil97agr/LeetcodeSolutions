class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        ans[0] = nums[0];
        for(int i=1;i<n;i++){
            ans[i] = Math.max(ans[i-1], nums[i]);
        }

        int min = nums[n-1];
        for(int i=n-2;i>=0;i--){
            min = Math.min(nums[i+1], min);
            if(min < ans[i]){
                ans[i] = Math.max(ans[i], ans[i+1]);
            }
        }

        return ans;
    }
}