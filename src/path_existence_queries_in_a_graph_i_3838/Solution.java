package path_existence_queries_in_a_graph_i_3838;

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int par[] = new int[n];
        for(int i=0;i<n;i++) par[i] = i;

        int prev = 0;

        for(int i=1;i<n;i++){
            if(nums[i] - nums[prev] <= maxDiff){
                int p1 = find(i, par);
                int p2 = find(prev, par);
                par[p1] = p2;
            }else{
                if(i== prev+1){
                    prev = i;
                    
                }else{
                    prev = i-1;
                    i--;
                }
            }
        }
        

        
        boolean ans[] = new boolean[queries.length];

        for(int i=0;i<queries.length;i++){
            int p1 = find(queries[i][0], par);
            int p2 = find(queries[i][1], par);

            if(p1 == p2){
                ans[i] = true;
            }
        }

        return ans;
        
    }

    private int find(int x, int par[]){
        if(par[x] == x) return x;

        return par[x] = find(par[x], par);
    }
}