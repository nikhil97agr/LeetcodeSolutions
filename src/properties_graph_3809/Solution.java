package properties_graph_3809;

import java.util.*;
class Solution {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;

        int par[] = new int[n];

        for(int i=0;i<n;i++) par[i] = i;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int p1 = find(par, i);
                int p2 = find(par, j);
                if(p1 == p2) continue;
                if(intersect(properties[i], properties[j], k)){
                    par[p1] = p2;
                }
            }
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(find(par, i));
        }
        return set.size();
    }

    private boolean intersect(int a[], int b[], int k){
        Set<Integer> set = new HashSet<>();
        for(int x : a) set.add(x);

        Set<Integer> set2 = new HashSet<>();
        for(int x : b){
            if(set.contains(x)) set2.add(x);
        }

        return set2.size() >= k;
    }


    private int find(int par[], int p){
        if(par[p] == p) return p;

        return par[p] = find(par, par[p]);
    }
}