package destroy_sequential_targets_2548;

import java.util.*;
class Solution {
    public int destroyTargets(int[] nums, int space) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int count = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=n-1;i>=0;i--){
            int mod = nums[i]%space;
            map.put(nums[i]%space, map.getOrDefault(nums[i]%space,0)+1);
            if(map.get(mod)>=count){
                count = map.get(mod);
                result = nums[i];
            }
            
        }
        return result;
    }
}