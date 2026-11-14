package maximum_value_of_an_alternating_sequence_4364;

class Solution {
    public long maximumValue(int n, int s, int m) {
        int half = n / 2;
        if( n == 1){
            return s;
        }

        if( n == 2){
            return 1l * s + m;
        }


            long a =  1l * s + m  + 1l * (half - 1) * (m - 1);

        long b = 1l * s + 1l * (n - half - 1) * (m - 1);

        return Math.max(a, b);
    }
}