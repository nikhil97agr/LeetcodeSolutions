package make_array_zero_by_subtracting_equal_amounts_2436;

import java.util.*;
class Solution {
    public int minimumOperations(int[] nums) {
        int total = 0;
        Arrays.sort(nums);
        int count = 0;
        for(int x : nums){
            if(x==0){
                continue;
            }
            if(x > total){
                total += x-total;
                count++;
            }
        }
        return count;
    }
}