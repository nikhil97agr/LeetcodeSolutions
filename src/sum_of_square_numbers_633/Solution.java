package sum_of_square_numbers_633;

class Solution {
    public boolean judgeSquareSum(int c) {
        for(long x = 0; x*x <= 1L*c;x++){
            long y = Math.abs(1L*c - x*x);
            long pow =(long) Math.sqrt(y);
            if(pow*pow == y){
                return true;
            }
        }
        return false;
    }
}