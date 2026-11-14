class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int zero = 0;
        int n = nums.length;
        for(int x : nums){
            if(x == 0){
                zero++;
            }
            xor ^= x;

        }

        if(xor != 0) return n;
        if(zero == n){
            return 0;
        }

        return n -1;

        
    }
}