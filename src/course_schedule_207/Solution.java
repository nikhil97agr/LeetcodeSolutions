package course_schedule_207;

import java.util.*;
class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        LinkedList<Integer> adjList[] = new LinkedList[n];
        int []indeg = new int[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }

        for(int p[] : prereq){
            adjList[p[1]].add(p[0]);
            indeg[p[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) que.add(i);
        }

        List<Integer> list = new ArrayList<>();
        while(!que.isEmpty()){
            int x = que.poll();
            list.add(x);
            Iterator<Integer> it = adjList[x].iterator();
            while(it.hasNext()){
                int t = it.next();
                indeg[t]--;
                if(indeg[t]==0) que.add(t);
            }
        }

        return list.size()==n;

    }
}