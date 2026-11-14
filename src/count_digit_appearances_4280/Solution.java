package count_digit_appearances_4280;

class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans = 0;
        for(int x : nums){
            ans+= cnt(x, digit);
        }
        return ans;
    }

    private int cnt(int n, int digit){
        int ans = 0;
        while(n > 0){
            int dig =n %10;
            if(dig == digit) ans++;
            n/=10;
        }

        return ans;
    }
}