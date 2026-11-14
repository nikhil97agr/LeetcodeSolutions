package contains_duplicate_iii_220;

import java.util.*;
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n= nums.length;
        int j = 0;
        for(int i=0;i<n;i++){
            Integer ceil = map.ceilingKey(nums[i]);
            Integer floor = map.floorKey(nums[i]);
            if(ceil != null && Math.abs(ceil - nums[i])<= valueDiff) return true;

            if(floor !=null && Math.abs(floor - nums[i])<=valueDiff) return true;
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

            if(map.size()>indexDiff){
                int cnt = map.get(nums[j]);
                if(cnt == 1 ){
                    map.remove(nums[j++]);
                }else{
                    map.put(nums[j], map.get(nums[j])-1);
                    j++;
                }
            }
        }
        return false;
    }
}