package minimum_number_of_operations_to_make_array_xor_equal_to_k_3249;

class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int x : nums){
            xor ^= x;
        }
        int ans = 0;
        for(int i=0;i<32;i++){
            int bit = k&(1<<i);
            int bit2 = xor&(1<<i);
            if(bit!=bit2)ans++;
        }
        
        return ans;
    }
}