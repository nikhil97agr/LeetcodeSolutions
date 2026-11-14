package check_good_integer_4332;

class Solution {
    public boolean checkGoodInteger(int n) {
        int s= 0;
        int sq = 0;
        while( n > 0){
            int d = n%10;
            s += d;
            sq += (d * d);
            n/=10;
        }

        return sq - s >= 50;
    }
}