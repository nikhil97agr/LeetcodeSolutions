package check_if_bitwise_or_has_trailing_zeros_3246;

class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for(int x : nums){
            if((x&1)==0) count++;
        }
        
        return count>=2;
    }
}