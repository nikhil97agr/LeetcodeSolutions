package largest_color_value_in_a_directed_graph_1986;

import java.util.*;
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int comingEdges[] = new int[n];
        LinkedList<Integer> adjList[] =new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }
        int dp[][] = new int[n][];
        for(int edge[] : edges){
            adjList[edge[0]].add(edge[1]);
        }
        boolean visited[] = new boolean[n];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dp[i] ==null){
                if(traverse(visited, dp, adjList, colors, i)){
                    return -1;
                }
                for(int j=0;j<26;j++){
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans; 
    }

    private boolean traverse(boolean visited[], int dp[][], LinkedList<Integer> adjList[], String colors, int node){
        if(dp[node]!=null){
            return false;
        }
        visited[node] =true;
        dp[node] = new int[26];
        dp[node][colors.charAt(node)-'a'] = 1;
        Iterator<Integer> it = adjList[node].iterator();
        while(it.hasNext()){
            int x = it.next();
            if(visited[x]){
                return true;
            }
            if(traverse(visited, dp, adjList, colors, x)){
                return true;
            }

            merge(x, dp, node, colors);
        }

        visited[node] = false;
        return false;
        
    }

    private void merge(int i, int dp[][], int j, String colors){
        char c = colors.charAt(j);
        dp[j][c-'a'] = Math.max(dp[j][c-'a'], 1 + dp[i][c-'a']);
        int n = colors.length();
        for(int k=0;k<26;k++){
            dp[j][k] = Math.max(dp[j][k], dp[i][k]);
        }
    }
}