package unit_conversion_ii_3752;

import java.util.*;
class Solution {
    long mod =(long)1e9 + 7;
    public int[] queryConversions(int[][] conversions, int[][] queries) {
        int q = queries.length;
        int n = conversions.length+1;
        LinkedList<int[]> adjList[] =new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }
        for(int[] c : conversions){
            int u = c[0];
            int v = c[1];
            int r = c[2];

            adjList[u].add(new int[]{v, r});
            adjList[v].add(new int[]{u, div(1,r)});
        }

        int ans[] = new int[q];
        int dist[] = new int[n];
        dist[0] = 1;
        dfs(dist, 0, -1, adjList);
        for(int i=0;i<q;i++){
            int src = queries[i][0];
            int dest = queries[i][1];
            if(src == dest){
                ans[i] = 1;
                continue;
            }
            ans[i] = div(dist[dest], dist[src]);

        }

        return ans;
    }

    private void dfs(int dist[], int curr, int par, LinkedList<int[]> adjList[]){
        for(int []child : adjList[curr]){
            int u = child[0];
            int c = child[1];
            if(u == par) continue;
            dist[u] = prod(dist[curr], c);
            dfs(dist, u, curr, adjList);
        }
    }
    private int div(int a, int b){
        return prod(a, pow(b, (int)(mod - 2)));
    }

    private int pow(int a, int b){
        if(a==0) return 0;
        if(b==0) return 1;
        if(a==1) return 1;
        if(b==1) return a;

        int prod= pow(a,b/2);
        prod= prod(prod, prod);
        if(b%2==1){
            prod = prod(prod ,a);
        }

        return prod;
    }
    private int prod(int a, int b){
        long prod = 1l*a*b;

        return (int)(prod%mod);
    }
}