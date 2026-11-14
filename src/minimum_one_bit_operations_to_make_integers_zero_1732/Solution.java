package minimum_one_bit_operations_to_make_integers_zero_1732;

class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0) return 0;

        int pow = (int)(Math.log(n)/Math.log(2));
        int num = 1<<pow;

        return (1<<(pow+1))-1 - minimumOneBitOperations((n^num));
    }
}