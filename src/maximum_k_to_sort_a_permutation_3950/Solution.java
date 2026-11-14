package maximum_k_to_sort_a_permutation_3950;

import java.util.*;
class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        List<Integer> list= new ArrayList<>();

        for(int i=0;i<n;i++){
            if(nums[i] !=i ){
                list.add(i);
            }
        }
        if(list.size() ==0) return 0;
        int and = list.get(0);

        for(int x : list) and &= x;

        return and;
    }
}