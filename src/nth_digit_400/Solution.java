package nth_digit_400;

class Solution {
    public int findNthDigit(int n1) {
        int i=1;
        long prev = 0;
        long n = n1;
        for(;i<=10 && n > 0;i++){
            long total = (long)Math.pow(10, i) -1 - prev;
            if(total * i ==n){
                return 9;
            }
            if(total*i < 1l*n){
                n -= total*i;
                prev += total;
            }else{
                break;
            }
        }
        long start = (long)Math.pow(10, i-1);
        long s = start;
        long end = (long)Math.pow(10, i) - 1;
        long num = -1;
        while(start <= end){
            long mid = start + (end - start)/2;
            if((mid - s + 1)*i > n){
                end = mid - 1;
            }else if((mid - s + 1)*i == n){
                return (int)(mid%10);
            }else{
                num = mid;
                start = mid + 1;
            }
        }

        if(num == -1){
            return Long.toString(s).charAt((int)n-1) - '0';
        }
        n-= (num - s+1)*i;
        num++;
        return Long.toString(num).charAt((int)n-1) - '0';
    }
}