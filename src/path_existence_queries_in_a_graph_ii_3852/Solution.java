package path_existence_queries_in_a_graph_ii_3852;

import java.util.*;
class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int q = queries.length;
        int ans[] = new int[q];
        Arrays.fill(ans, -1);

        int log = 20;
        int pair[][] = new int[n][2];
        for(int i=0;i<n;i++){
            pair[i] = new int[]{nums[i], i};
        }

        Arrays.sort(pair, (a,b) -> a[0] - b[0]);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(pair[i][1], i);
        }
        int par[][] = new int[n][20];

        for(int i=0;i<n;i++){
            int start =i;
            int end = n - 1;
            int ind =i;
            while(start <= end){
                int mid = (start + end) / 2;
                if(pair[mid][0] - pair[i][0] <= maxDiff){
                    ind = mid;
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }

            par[i][0] = ind;

        }

        for(int j=1;j<log;j++){
            for(int i=0;i<n;i++){
                int p = par[i][j-1];
                par[i][j] = par[p][j-1];
            }
        }

        for(int i=0;i<q;i++){
            int u = queries[i][0];
            int v= queries[i][1];

            int iStart = map.get(u);
            int iEnd = map.get(v);

            int min = Math.min(iStart, iEnd);
            int max = Math.max(iStart, iEnd);
            if(min == max){
                ans[i] = 0;
                continue;
            }

            int total = 0;
            for(int j = log - 1;j>=0;j--){
                if(par[min][j] < max){

                    total += (1 << j);
                    min = par[min][j];
                }
            }

            if(par[min][0] >= max){
                total++;
                ans[i] = total;
            }
        }


        return ans;
    }
}