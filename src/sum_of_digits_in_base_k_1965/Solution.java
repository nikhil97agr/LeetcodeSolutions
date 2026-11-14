package sum_of_digits_in_base_k_1965;

class Solution {
    public int sumBase(int n, int k) {
        int sum =0;

        while ( n > 0){
            sum += n%k;
            n/=k;
        }

        return sum;
    }
}