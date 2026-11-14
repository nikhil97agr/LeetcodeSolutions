package maximum_requests_without_violating_the_limit_4250;

import java.util.*;
class Solution {
    public int maxRequests(int[][] requests, int k, int window) {
        Arrays.sort(requests, (a,b) -> a[1] - b[1]);
        int n= requests.length;
        int dropped = 0;
        Queue<int[]> que= new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        for(int t =1;t<=100000;t++){
            while(!que.isEmpty() && que.peek()[1] < t){
                int req[] = que.poll();
                remove(req[0], map);
            }
            int end = t + window;
            while( i < n && requests[i][1] >= t && requests[i][1] <= end){
                int next[] = requests[i];
                if(map.getOrDefault(next[0],0) == k){
                    dropped++;
                }else{
                    add(next[0], map);
                    que.offer(next);
                }
                i++;
            }
        }
        
        
        return n - dropped;
    }

    private void remove(int val, Map<Integer, Integer> map){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);
    }

    private void add(int val, Map<Integer, Integer> map){
        map.merge(val, 1, Integer::sum);
    }
}