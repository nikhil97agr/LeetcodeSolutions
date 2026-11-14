package find_minimum_operations_to_make_all_elements_divisible_by_three_3476;

import java.util.*;
class Solution {
    public int minimumOperations(int[] nums) {
        return (int)Arrays.stream(nums).filter(x -> x%3!=0).count();
    }
}