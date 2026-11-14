package find_score_of_an_array_after_marking_all_elements_2695;

import java.util.*;
class Solution {
    public long findScore(int[] nums) {
        long ans = 0;
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        set.add(-1);
        set.add(n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for(int i=0;i<n;i++){
            pq.offer(new int[]{nums[i], i});
        }

        while(!pq.isEmpty()){
            while(!pq.isEmpty() && set.contains(pq.peek()[1])){
                pq.poll();
            }

            if(!pq.isEmpty()){
                int last[] = pq.poll();
                ans += last[0];
                set.add(last[1]);
                set.add(last[1]-1);
                set.add(last[1]+1);
            }
        }
        return ans;
    }
}