package replace_elements_in_an_array_2388;

import java.util.*;
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        
        for(int x[] : operations){
            int ind = map.get(x[0]);
            map.put(x[1], ind);
            map.remove(x[0]);
            nums[ind] = x[1];
        }
        return nums;
    }
}