class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        if(num1 == 0) return 0;
        for(long i=0;i<=60;i++){
            long num = 1l*num1 - i*num2;

            if(check(num, i)){
                return (int)i;
            }
        }

        return -1;
    }
    private boolean check(long num, long cnt){
        if(cnt > num) return false;
        
        if(num <= 0) return false;
        int c = 0;
        int i=60;
        while(num > 0 && i >=0){
            long x = (1l<<i);

            if(x <= num){
                num -= x;
                c++;
            }
            i--;
        }

        return num ==0 && c <= cnt;
    }
}