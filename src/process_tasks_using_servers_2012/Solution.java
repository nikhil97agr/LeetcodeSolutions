package process_tasks_using_servers_2012;

import java.util.*;
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> unavailable= new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                if(a[1] == b[1]){
                    return a[2] - b[2];
                }

                return a[1] - b[1];
            }

            return a[0] - b[0];
        });
        PriorityQueue<int[]> available = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        }); 

        int n =servers.length;
        int m = tasks.length;
        int ans[] = new int[m];

        for(int i=0;i<n;i++){
            available.offer(new int[]{servers[i], i});
        }

        for(int i=0;i<m;i++){
            while(!unavailable.isEmpty() && unavailable.peek()[0] <= i){
                int next[] = unavailable.poll();
                available.offer(new int[]{next[1], next[2]});
            }
  
            if(available.isEmpty()){
                int next[] =unavailable.poll();
                next[0] += tasks[i];
                ans[i] = next[2];
                unavailable.offer(next);
            }else{
                int next[] = available.poll();
                ans[i] = next[1];
                unavailable.offer(new int[]{i + tasks[i], next[0], next[1]});
            }

        }
        

        return ans;
    }
}