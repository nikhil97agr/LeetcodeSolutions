package find_three_consecutive_integers_that_sum_to_a_given_number_2278;

class Solution {
    public long[] sumOfThree(long num) {
        if(num%3!=0) return new long[0];

        long val = num/3;
        return new long[]{val-1, val, val+1};
    }
}