package convert_integer_to_the_sum_of_two_no_zero_integers_1440;

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            int a = i;
            int b = n-i;
            if(!isZero(a) && !isZero(b)){
                return new int[]{a,b};
            }
        }

        return new int[2];
    }

    private boolean isZero(int x){
        while(x > 0){
            int dig = x%10;
            if(dig ==0) return true;
            x/=10;
        }
        return false;
    }
}