package bitwise_and_of_numbers_range_201;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(right > left){
            right &= (right-1);
        }
        return right;
    }
}