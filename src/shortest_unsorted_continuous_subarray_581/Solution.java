package shortest_unsorted_continuous_subarray_581;

import java.util.*;
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start =-1;
        int end = -1;
        int sort[] = nums.clone();
        Arrays.sort(sort);

        for(int i=0;i<nums.length;i++){
            if(nums[i] != sort[i]){
                if(start == -1){
                    start = i;
                }
                end = i;
            }
        }


        return start == -1 ? 0 : end - start+1;
    }
}