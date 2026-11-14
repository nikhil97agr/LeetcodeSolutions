package smallest_number_with_all_set_bits_3676;

class Solution {
    public int smallestNumber(int n) {
        int pow = (int)(Math.log(n)/Math.log(2));
        return (1<<(pow+1)) -1 ;
    }
}