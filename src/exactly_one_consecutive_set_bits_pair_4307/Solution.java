package exactly_one_consecutive_set_bits_pair_4307;

class Solution {
    public boolean consecutiveSetBits(int n) {
        int cnt = 0;
        char bit[] = Integer.toBinaryString(n).toCharArray();

        for(int i=1;i<bit.length;i++){
            if(bit[i] == '1' && bit[i] == bit[i-1]) cnt++;
        }

        return cnt == 1;
    }
}