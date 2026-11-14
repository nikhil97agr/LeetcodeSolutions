package subarrays_with_k_different_integers_1034;

import java.util.*;
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int upper = solve(nums, k);
        int lower = solve(nums, k-1);
        return upper - lower;
        
    }
    
    public int solve(int nums[], int k){
        HashMap<Integer, Integer> map = new HashMap();
        int result = 0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            while(map.size()>k){
                int val = map.get(nums[j]);
                map.put(nums[j], val-1);
                if(val==1){
                    map.remove(nums[j]);
                }
                j++;
            }
            result  += (i-j+1);
        }
        return result;
    }
}