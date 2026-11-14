package checking_existence_of_edge_length_limited_paths_1815;

import java.util.*;
class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int m = queries.length;
        boolean result[] = new boolean[m];
        int parent[] = new int[n];
        int e = edgeList.length;
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        Arrays.sort(edgeList, (e1,e2)->  e1[2]-e2[2]);
        int q[][] = new int[m][4];
        for(int i=0;i<m;i++){
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(queries, (q1,q2)->  q1[2]-q2[2]);
        int j= 0;
        for(int i=0;i<m;i++){
            while(j<e && edgeList[j][2] < queries[i][2]){
                union(parent, edgeList[j][0], edgeList[j][1]);
                j++;

            }

            result[queries[i][3]] = find(parent, queries[i][0]) == find(parent,queries[i][1]);
        }
        return result;
    }

    private void union(int parent[], int i, int j){
        int p1 = find(parent, i);
        int p2 = find(parent, j);
        if(p1!=p2){
            parent[p1] = p2;

        }
    }

    private int find(int parent[], int i){
        return parent[i] = ((parent[i]==i)? i : find(parent, parent[i]));
    }
}