package concatenation_of_consecutive_binary_numbers_1800;

class Solution {
    public int concatenatedBinary(int n) {
        long x = 1;
        long total = 0;
        long mod = (long)1e9+7;
        int digits= 0;
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0){
                digits++;
            }
            
            total = ((total<<digits)+i)%mod;
        }
        return (int)total;
    }
}