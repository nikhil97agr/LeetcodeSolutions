class Solution {
    public int addDigits(int num) {
        int n = 0;
        while(num>0){
            int digit = num%10;
            n+=digit;
            num/=10;
            if(num==0){
                if(n<10){
                    return n;
                }
                
                num = n;
                n=0;
            }
        }
        return 0;
    }
}