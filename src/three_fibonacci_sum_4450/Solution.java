package three_fibonacci_sum_4450;

class Solution {
    public boolean threeFibonacciSum(int n) {
        int first = 0;
        int second = 1;
        int third = 1;

        while(first + second + third < n){
            first = second;
            second = third;
            third = first + third;
        }

        return first + second + third == n;
    }
}