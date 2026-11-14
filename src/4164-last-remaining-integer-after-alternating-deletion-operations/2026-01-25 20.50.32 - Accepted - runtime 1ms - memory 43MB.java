class Solution {
    public long lastInteger(long n) {
        long ans = 1;
        long diff = 1;
        boolean isLeft= true;
        while( n > 1){
            if(!isLeft && n%2==0){
                ans = ans + diff;
            }
            n = (n+1)/2;
            isLeft = !isLeft;
            diff <<=1;
        }

        return ans;
    }
}