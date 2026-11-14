package count_values_with_equally_spaced_occurrences_ii_4414;

import java.util.*;
class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for(var l : map.values()){
            if(l.size() >= 3){
                boolean flag= true;
                int diff = l.get(1) - l.get(0);
                for(int i=1;i<l.size();i++){
                    if(l.get(i) - l.get(i-1) != diff){
                        flag = false;
                        break;
                    }
                }
                if(flag) ans++;
            }
        }


        return ans;
    }
}