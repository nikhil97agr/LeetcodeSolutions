package special_array_with_x_elements_greater_than_or_equal_x_1730;

import java.util.*;
class Solution {
    public int specialArray(int[] nums) {
        int x = Arrays.stream(nums).max().getAsInt();

        for(int i=1;i<=x;i++){
            int cnt = 0;
            for(int y : nums){
                if(y >= i){
                    cnt++;
                }
            }
            if(cnt ==i) return i;

        }
        return -1;
    }
}