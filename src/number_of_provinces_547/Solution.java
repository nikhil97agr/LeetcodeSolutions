package number_of_provinces_547;

import java.util.*;
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        DSU dsu = new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    dsu.union(i,j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(dsu.find(i));
        }

        return set.size();
    }
}

class DSU{
    int parent[];
    public DSU(int n){
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    public void union(int i, int j){
        int p1 = find(i);
        int p2 = find(j);
        if(p1!=p2) parent[p1] = p2;
    }
    public int find(int i){
        return parent[i]==i ? i : (parent[i] = find(parent[i]));
    }
}