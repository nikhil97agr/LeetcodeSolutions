package maximum_equal_frequency_1344;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        new Solution().maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5});
    }
    public int maxEqualFreq(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Integer> valMap= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            if(valMap.containsKey(x)){
                int cnt = valMap.get(x);
                cntMap.merge(cnt, -1, Integer::sum);
                if(cntMap.get(cnt) ==0){
                    cntMap.remove(cnt);
                }
                valMap.put(x, cnt + 1);
                cntMap.merge(cnt +1 , 1 , Integer::sum);
            }else{
                valMap.put(x, 1);
                cntMap.merge(1, 1, Integer::sum);
            }
            
            if(cntMap.size() > 2) continue;
            if(cntMap.size() == 1){
                if(cntMap.containsKey(1)){
                    ans = i + 1;
                    continue;
                }
                int key = new ArrayList<>(cntMap.keySet()).get(0);
                if(cntMap.get(key) == 1){
                    ans = i+1;
                }
                continue;
            }

            List<Integer> key = new ArrayList<>(cntMap.keySet());

            int min = Math.min(key.get(0), key.get(1));
            int max = Math.max(key.get(0), key.get(1));
            if(min == 1){
                if(cntMap.get(min) == 1){
                    ans = i+1;
                    continue;
                }
            }

            if(max - 1 == min && cntMap.get(max) == 1){
                ans = i+1;
            }

  

        }

        return ans;
    }
}