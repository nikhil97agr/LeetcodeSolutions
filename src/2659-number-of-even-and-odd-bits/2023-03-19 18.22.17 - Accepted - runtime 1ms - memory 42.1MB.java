class Solution {
    public int[] evenOddBit(int n) {
        int even = 0;
        int odd = 0;
        int ind = 0;
        while(n>0){
            int mod = n%2;
            n/=2;
            if(mod==1){
                int tmep = (ind%2==0) ? (++even) : (++odd);
            }
            ind++;
        }
        
        
        return new int[]{even, odd};
    }
}