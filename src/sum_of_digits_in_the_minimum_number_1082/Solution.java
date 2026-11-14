package sum_of_digits_in_the_minimum_number_1082;

import java.util.*;
class Solution {
    public int sumOfDigits(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();

        int sum = 0;
        while(min > 0){
            sum += min%10;
            min/=10;
        }

        return Math.abs(1 - (sum%2));
    }
}