package maximum_xor_after_operations_2402;

class Solution {
    public int maximumXOR(int[] nums) {
        int ans = 0;
        for(int x : nums){
            ans |= x;
        }

        return ans;
    }
}