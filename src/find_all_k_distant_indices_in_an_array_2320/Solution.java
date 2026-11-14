package find_all_k_distant_indices_in_an_array_2320;

import java.util.*;
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j] == key && Math.abs(i-j) <=k){
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}