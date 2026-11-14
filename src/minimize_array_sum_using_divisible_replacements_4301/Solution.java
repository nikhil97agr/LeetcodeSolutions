package minimize_array_sum_using_divisible_replacements_4301;

import java.util.*;
class Solution {
    public long minArraySum(int[] nums) {

        int clone[] = nums.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : clone){
            if(map.containsKey(x)){
                continue;
            }

            for(int j=x;j<=100000;j+=x){
                map.putIfAbsent(j, x);
            }
        }

        long ans = 0;
        for(int x : nums){
            ans += map.get(x);
        }

        return ans;
    }
}