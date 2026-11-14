package closest_node_to_path_in_tree_2420;

import java.util.*;
class Solution {
    public int[] closestNode(int n, int[][] edges, int[][] query) {
        Set<Integer> set[] =new HashSet[n];
        for(int i=0;i<n;i++) set[i] = new HashSet<>();
        for(int e[] : edges){
            set[e[0]].add(e[1]);
            set[e[1]].add(e[0]);
        }
        int dp[][] = new int[n][n];

        for(int i=0;i<n;i++){
            boolean visited[] =new boolean[n];
            Queue<int[]> que = new LinkedList<>();
            que.add(new int[]{i, 0});
            visited[i] = true;
            while(!que.isEmpty()){
                int node[] = que.poll();
                dp[i][node[0]] = node[1];

                for(int x : set[node[0]]){
                    if(!visited[x]){
                        que.add(new int[]{x, node[1]+1});
                        visited[x] = true;
                    }
                }
            }

        }
        for(int x[] : dp){
            System.out.println(Arrays.toString(x));
        }
        int m = query.length;
        int ans[] = new int[m];
        for(int i=0;i<m;i++){
            int start = query[i][0];
            int end = query[i][1];
            int node= query[i][2];

            int res[] = new int[]{start};
            dfs(start, -1,end, node, dp, set, res);
            ans[i] = res[0];

        }
        return ans;
    }

    private boolean dfs(int start, int parent, int end, int node, int dp[][], Set<Integer> set[], int ans[]){
        if(start == end){
            if(dp[ans[0]][node] > dp[start][node]){
                ans[0] = start;
                
            }
            return true;
        }

        for(int i : set[start]){
            if(i!=parent){
                if(dfs(i, start, end, node, dp, set, ans)){
                    if(dp[ans[0]][node] > dp[start][node]) ans[0] = start;
                    return true;
                }
            }
        }
        return false;
    }
}