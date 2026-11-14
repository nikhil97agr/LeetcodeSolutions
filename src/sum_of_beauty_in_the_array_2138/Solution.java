package sum_of_beauty_in_the_array_2138;

import java.util.*;
class Solution {
    public int sumOfBeauties(int[] nums) {
        TreeMap<Integer, Integer> suff = new TreeMap<>();
        TreeMap<Integer, Integer> pref = new TreeMap<>();
        int ans = 0;
        int n = nums.length;
        for(int i=2;i<n;i++){
            suff.merge(nums[i], 1, Integer::sum);

        }
        pref.put(nums[0], 1);

        for(int i=1;i<n-1;i++){
            Integer left = pref.ceilingKey(nums[i]);
            Integer right = suff.floorKey(nums[i]);
            if(left == null && right == null){
                ans += 2;
            }else{
                if(nums[i-1] < nums[i] && nums[i] < nums[i+1]){
                    ans += 1;
                }
            }

            pref.merge(nums[i], 1, Integer::sum);
            suff.merge(nums[i+1], -1, Integer::sum);
            if(suff.get(nums[i+1]) ==0) suff.remove(nums[i+1]);
        }


        return ans;
    }
}