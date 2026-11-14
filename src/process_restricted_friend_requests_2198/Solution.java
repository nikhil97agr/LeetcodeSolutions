package process_restricted_friend_requests_2198;

import java.util.*;
class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        Set<Integer> list[] = new HashSet[n];
        int parent[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            list[i] = new HashSet<>();
        }
        for(int res[] : restrictions){
            list[res[0]].add(res[1]);
            list[res[1]].add(res[0]);
        }
        int m = requests.length;
        boolean ans[] = new boolean[m];
        int i=0;
        for(int req[] : requests){
            int p1 = find(parent, req[0]);
            int p2 = find(parent, req[1]);
            
            if(p1==p2){
                ans[i] = true;
            }else if(!list[p1].contains(p2) && !list[p2].contains(p2)){
                parent[p1]= p2;

                list[p2].addAll(list[p1]);

                for(int x : list[p1]){
                    list[x].add(p2);
                }
                ans[i] = true;
            }else{
                ans[i] = false;
            }

            i++;
        }
        return ans;
    }

    private int find(int parent[], int i){
        if(parent[i]==i) return i;

        return parent[i] = find(parent, parent[i]);
    }
}