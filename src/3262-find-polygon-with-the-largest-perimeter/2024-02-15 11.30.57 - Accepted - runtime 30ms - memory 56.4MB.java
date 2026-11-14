class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long ans =0;
        long sum = 0;
        sum = nums[0] + nums[1];
        
        for(int i=2;i<nums.length;i++){
            if(sum > nums[i]){
                ans = Math.max(ans, sum + nums[i]);
            }
            sum += nums[i];
        }
        
        return ans ==0 ? -1 : ans;
    }
}