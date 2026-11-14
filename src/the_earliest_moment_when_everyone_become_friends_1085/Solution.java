package the_earliest_moment_when_everyone_become_friends_1085;

import java.util.*;
class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b)->a[0] - b[0]);
        int ans = 0;
        int parent[] = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
        }
        for(int x[] : logs){
            int a = x[1];
            int b = x[2];
            int p1 = findParent(parent, a);
            int p2 = findParent(parent, b);
            if(p1!=p2){
                parent[p1] = p2;
                ans = x[0];
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(findParent(parent, i));
        }

        if(set.size()==1) return ans;
        return -1;
    }

    private int findParent(int parent[], int i){
        if(parent[i] == i) return i;
        return parent[i] = findParent(parent, parent[i]);
    }
}