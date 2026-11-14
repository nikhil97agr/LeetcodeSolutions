package count_elements_with_strictly_smaller_and_greater_elements_2269;

import java.util.*;
class Solution {
    public int countElements(int[] nums) {
        int small = Arrays.stream(nums).min().getAsInt();

        int large = Arrays.stream(nums).max().getAsInt();

        int ans = 0;
        for(int x : nums){
            if(x!= large && x!=small) ans++;
        }
        return ans;
    }
}