package minimum_swaps_to_move_zeros_to_end_4316;

class Solution {
    public int minimumSwaps(int[] nums) {
        int zero =0 ;
        int ans = 0;
        int n = nums.length;
        for(var x : nums){
            if(x==0) zero++;
        }

        for(int i=n-1;i>=0 && zero > 0;i--, zero--){
            if(nums[i] !=0){
                ans++;
            }
        }

        return ans;
    }
}