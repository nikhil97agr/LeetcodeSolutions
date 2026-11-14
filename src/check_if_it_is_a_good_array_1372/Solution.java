package check_if_it_is_a_good_array_1372;

class Solution {
    public boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        for(int x : nums){
            gcd = gcd(x, gcd);
        }

        return gcd == 1;
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}