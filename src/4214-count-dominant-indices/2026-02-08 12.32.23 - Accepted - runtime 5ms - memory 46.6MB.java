class Solution {
    public int dominantIndices(int[] nums) {
        int ans = 0;
        int sum = Arrays.stream(nums).sum();
        int total = nums.length;
        for(int i=0;i<nums.length-1;i++){
            sum -= nums[i];
            total--;
            if(nums[i] > sum/total) ans++;
        }
        return ans;
    }
}