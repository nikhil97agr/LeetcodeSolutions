package count_distinct_numbers_on_board_2679;

class Solution {
    public int distinctIntegers(int n) {
        if(n==1){
            return 1;
        }
        return n-1;
    }
}