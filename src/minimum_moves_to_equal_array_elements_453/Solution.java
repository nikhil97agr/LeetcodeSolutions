package minimum_moves_to_equal_array_elements_453;

import java.util.*;
class Solution {
    public int minMoves(int[] nums) {
        int ans = 0;
        int min = Arrays.stream(nums).min().getAsInt();

        for(int x : nums){
            ans += x - min;
        }

        return ans;
    }
}