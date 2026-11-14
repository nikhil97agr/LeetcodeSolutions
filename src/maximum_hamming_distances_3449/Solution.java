package maximum_hamming_distances_3449;

import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] maxHammingDistances(int[] nums, int m) {
        var set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        var map = new HashMap<Integer, Integer>();
        var que = new LinkedList<Integer>();
        for(int x : set){
            var complement = (~x) & ((1<<m)-1);
            map.put(complement, 0);
            que.offer(complement);
        }

        while(!que.isEmpty()){
            var next = que.poll();
            for(var i=0;i<m;i++){
                var y = next ^ (1<<i);
                if(!map.containsKey(y)){
                    map.put(y, map.get(next)+ 1);
                    que.offer(y);
                }
            }
        }

        int ans[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = m - map.get(nums[i]);
        }

        return ans;
    }
}