package find_the_minimum_number_of_fibonacci_numbers_whose_sum_is_k_1515;

class Solution {
    public int findMinFibonacciNumbers(int k) {
        if( k < 2) return k;

        int a = 1;
        int b = 1;

        while( b <= k){
            b += a;
            a = b - a;
        }
        int cnt = k / a;
        return cnt + findMinFibonacciNumbers(k - a * cnt);
    }
}