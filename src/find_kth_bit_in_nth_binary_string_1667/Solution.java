package find_kth_bit_in_nth_binary_string_1667;

class Solution {
    public char findKthBit(int n, int k) {
        if(n==1 ) return '0';

        int len = 1<<n;

        if(k < len / 2) return findKthBit(n-1, k);

        if(k == len/2) return '1';

        char reverse = findKthBit(n-1, len - k);
        return reverse == '0' ? '1' : '0';
    }
}