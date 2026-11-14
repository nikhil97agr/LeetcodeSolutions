package minimum_bit_flips_to_convert_number_2323;

class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        for(int i=0;i<32;i++){
            int b1 = start&(1<<i);
            int b2 = goal&(1<<i);
            if((b1 !=0 && b2 !=0) || (b2==0 && b1 ==0)){
                continue;
            }else{
                ans++;
            }

        }
        return ans;
    }
}