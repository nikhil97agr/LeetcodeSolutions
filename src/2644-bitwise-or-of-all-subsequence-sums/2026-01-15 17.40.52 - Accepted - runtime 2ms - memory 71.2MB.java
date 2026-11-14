class Solution {
    public long subsequenceSumOr(int[] nums) {
        long prefix = 0;
        long ans = 0;
        for(int x : nums){
            ans = ans | x;
            prefix += x;
            ans |= prefix;
        }

        return ans;
    }
}