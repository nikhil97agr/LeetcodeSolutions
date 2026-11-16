package abbreviating_the_product_of_a_range_2222;

class Solution {
    public String abbreviateProduct(int left, int right) {
        long end = 1;
        double start = 1;
        int zero = 0;
        boolean reduced =false;
        long mod = 1_000_000_000_000l;
        long digitThresh = 1_000_000_0000l;
        for(int i = left;i<=right;i++){
            end *= i;
            while(end %10==0){
                end/=10;
                zero++;
            }

            if(end >= mod){
                end %= mod;
                reduced = true;
            }
        }


        if(!reduced && end < digitThresh){
            return end +"e"+zero;
        }

        for(int i=left;i<=right;i++){
            start *= i;
            while(start >= mod){
                start /= 10;
            }
        }
        while(start >= 100_000){
            start/=10;
        }

        end %= 100_000;

        return String.format("%d...%05de%d",(int) start, end, zero);
    }
}