class Solution {
    public int kthDigit(long k) {
        if( k <= 9){
            return (int)k;
        }

        k-= 9;

        long b = 1;

        while(true){
            long start = 10 * b;
            int digits = String.valueOf(start).length();

            long p = 1;
            for(int i=0;i< digits - 1;i++){
                p *= 10;
            }

            long max = p - 1;

            long block = max - b +1;

            long blockDigit = 10l * digits;
            long grp = block * blockDigit;

            if(k > grp){
                k-= grp;
                b = max + 1;
            }else{
                long offset = ( k - 1) / blockDigit;
                b += offset;
                k -= offset * blockDigit;

                int l = digits;

                long ind = ( k - 1)/l;
                long rem = (k - 1)%l;

                long ans = 0;
                if(b%2==0){
                    ans = 10 * b + ind;
                    
                }else{
                    ans = 10 * b + 9 - ind;
                }

                return String.valueOf(ans).charAt((int)rem) - '0';
                
            }
        }
    }
}