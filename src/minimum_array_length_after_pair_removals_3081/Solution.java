package minimum_array_length_after_pair_removals_3081;

import java.util.*;
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        int i=0;
        int j = (n+1)/2;
        int cnt = 0;
        while( j < n){
            if(nums.get(i) < nums.get(j)){
                cnt+=2;
                i++;
            }
            j++;
        }

        return n- cnt;
    }
}