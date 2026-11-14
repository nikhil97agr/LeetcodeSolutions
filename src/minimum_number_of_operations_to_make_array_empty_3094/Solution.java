package minimum_number_of_operations_to_make_array_empty_3094;

import java.util.*;
class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean res= true;
        int ans = 0;
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for(int val : map.values()){
            if(val == 1){
                res = false;
                break;
            }
            if(val <= 3){
                ans++;
                continue;
            }
            if(val%3==0){
                ans+= val/3;
                continue;
            }
            if(val%3==2){
                ans += 1 + val/3;
                continue;
            }
            if(val%3==1){
                ans += 2;
                ans += (val-4)/3;
                continue;
            }
        }

        if(!res) return -1;
        return ans;
    }
}