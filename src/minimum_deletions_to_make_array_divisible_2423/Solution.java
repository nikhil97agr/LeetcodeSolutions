package minimum_deletions_to_make_array_divisible_2423;

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        for(int x : numsDivide){
            gcd = gcd(x, gcd);
        }

        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for(int x : nums){
            if(gcd%x==0) min = Math.min(min, x);
        }

        if(min == Integer.MAX_VALUE) return -1;
        for(int x : nums){
            if(x < min) cnt++;
        }
        return cnt;
    }

    private int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
}