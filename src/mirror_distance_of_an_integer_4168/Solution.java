package mirror_distance_of_an_integer_4168;

class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - rev(n));
    }

    private int rev(int x){
        int res = 0;

        while( x > 0){
            int dig = x%10;

            res = res * 10 + dig;
            x/=10;
        }

        return res;
    }
}