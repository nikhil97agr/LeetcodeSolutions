package task_scheduler_621;

import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int cnt[] =new int[26];
        for(char c : tasks){
            cnt[c-'A']++;
        }
        for(int x : cnt){
            if(x > 0) que.offer(x);
        }
        int ans = 0;
        while(!que.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int freeSlots = n+1;
            while(freeSlots > 0 && !que.isEmpty()){
                int x  = que.poll();
                if(x > 1){
                    list.add(x-1);
                }
                freeSlots--;
                ans++;
            }

            que.addAll(list);
            if(que.isEmpty()) return ans;
            ans += freeSlots;
        }
        return ans;
    }
}