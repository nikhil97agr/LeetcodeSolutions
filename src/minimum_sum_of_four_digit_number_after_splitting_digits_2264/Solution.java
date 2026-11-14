package minimum_sum_of_four_digit_number_after_splitting_digits_2264;

import java.util.*;
class Solution {
    public int minimumSum(int num) {
        int dig[] = new int[4];
        int i=0;
        while(num > 0){
            int x = num%10;
            dig[i++] = x;
            num/=10;
        }
        Arrays.sort(dig);

        return dig[0]*10 + dig[1]*10 + dig[2] + dig[3];
    }

}