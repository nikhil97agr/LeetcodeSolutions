package a_number_after_a_double_reversal_2238;

class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num ==0) return true;

        if(num%10 ==0) return false;
        return true;
    }
}