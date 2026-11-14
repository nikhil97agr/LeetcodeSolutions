class Solution {
    public int maximumPossibleSize(int[] nums) {
        int ans = 0;
        
        int prev = nums[0];
        for(int x : nums){
            if( x>= prev){
                prev = x;
                ans++;
            }
        }

        return ans;
    }
}