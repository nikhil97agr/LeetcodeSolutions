package binary_number_with_alternating_bits_693;

class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n%2==0 ? 1 : 0;

        while(n> 0){
            int mod = n%2;
            if(prev == mod) return false;
            prev= mod;
            n/=2;
        }

        return true;
    }
}