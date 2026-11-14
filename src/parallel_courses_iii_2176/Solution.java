package parallel_courses_iii_2176;

import java.util.*;
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int res[] = new int[n];
        LinkedList<Integer> adjList[] = new LinkedList[n];
        int degree[] = new int[n];
        for(int  i=0;i<n;i++) adjList[i] = new LinkedList<>();
        for(int r[] : relations){
            adjList[r[0]-1].add(r[1]-1);
            degree[r[1]-1]++;
        }

        int ans = 0;
        Queue<Integer> que  = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int c = que.poll();

            ans = Math.max(ans, res[c]+time[c]);

            for(int x : adjList[c]){
                degree[x]--;
                res[x] = Math.max(res[x], res[c] + time[c]);
                if(degree[x]==0){
                    que.add(x);
                }
            }
        }

        return ans;
    }
}