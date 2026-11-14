package find_the_maximum_number_of_elements_in_subset_3299;

import java.util.*;
class Solution {
    public int maximumLength(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.merge(x, 1, Integer::sum);
        }

        int ans = map.getOrDefault(1, 1);

        if(ans%2==0) ans--;

        for(var entry : map.entrySet()){
            var key = entry.getKey();
            var val =entry.getValue();

            if(val == 1 || key == 1) continue;

            int c = 1;
            long next = 1l * key * key;
            while(next < Integer.MAX_VALUE && map.containsKey((int)next)){
                int cnt = map.get((int)next);
                if(cnt == 1){
                    ans = Math.max(ans, 2 * c + 1);
                    break;
                }else{
                    c++;
                    ans = Math.max(ans, 2 * c - 1);

                }
                next *= next;
            }
        }

        return ans;
    }
}