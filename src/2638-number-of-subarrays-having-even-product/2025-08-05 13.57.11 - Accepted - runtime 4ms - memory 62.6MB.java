class Solution {
    public long evenProduct(int[] nums) {
        long ans = 0;

        int prev = -1;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                ans += 1l*(i - prev)*(n - i);
                prev = i;
            }
        }
        return ans;
    }
}