package number_of_ways_to_assign_edge_weights_i_3844;

import java.util.*;
class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length+1;

        LinkedList<Integer> adjList[] = new LinkedList[n];

        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();

        for(int e[] : edges){
            int u = e[0]-1;
            int v = e[1]-1;

            adjList[u].add(v);
            adjList[v].add(u);
        }

        int depth = depth(0, -1, adjList);
        int ans = 0;
        List<List<Integer>> list = new ArrayList<>();

        // dfs(0, -1, list, new ArrayList<>(), depth, adjList);
        Integer dp[][] = new Integer[depth+1][2];
        ans = solve(0,0 ,depth, dp);
        return ans;
    }

    private int solve(int i, int sum, int n, Integer dp[][]){
        if(i==n){
            if(sum ==0) return 0;
            return 1;
        }
        if(dp[i][sum]!=null) return dp[i][sum];
        return dp[i][sum] = add(solve(i+1, (sum+1)%2, n, dp), solve(i+1, (sum+2)%2, n, dp));
    }

    private void dfs(int curr, int par, List<List<Integer>> path, List<Integer> list, int depth, LinkedList<Integer> adjList[]){
        list.add(curr);
        if(adjList[curr].size() ==1 && curr != 0){
            if(depth ==0){
                path.add(new ArrayList<>(list));
            }

            list.remove(list.size()-1);

            return; 
        }

        for(int child : adjList[curr]){
            if(par != child){
                dfs(child, curr, path, list, depth - 1, adjList);
            }
        }

        list.remove(list.size()-1);
    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;

        long sum = (long)a + b;


        return (int)(sum%mod);
    }

    private int depth(int curr, int par, LinkedList<Integer> adjList[]){
        if(adjList[curr].size() == 1 && curr != 0) return 0;


        int d = 0;

        for(int child : adjList[curr]){
            if(child != par){
                d = Math.max(d,  depth(child, curr, adjList));
            }
        }

        return d + 1;


    }
}