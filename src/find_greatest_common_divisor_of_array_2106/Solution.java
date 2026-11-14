package find_greatest_common_divisor_of_array_2106;

class Solution {
    public int findGCD(int[] nums) {
        int min = 10001;
        int max = 0;
        for(int x : nums){
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        return gcd(min, max);
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}