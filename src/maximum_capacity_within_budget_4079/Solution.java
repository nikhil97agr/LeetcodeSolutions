package maximum_capacity_within_budget_4079;

import java.util.*;
class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int m[][] = new int[n][2];
        int minCost = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            m[i] = new int[]{costs[i], capacity[i]};
            minCost = Math.min(minCost, costs[i]);
        }

        if(minCost >= budget) return 0;
        
        if(n==1){
            return capacity[0];
        }
        Arrays.sort(m, (a,b)-> a[0] - b[0]);

        int pre[] = new int[n];
        pre[0] = m[0][1];
        for(int i=1;i<n;i++){
            pre[i] = Math.max(pre[i-1], m[i][1]);
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            int req = budget - m[i][0];
            if(req <= 0) continue;
            int ind = search(m, req, 0, i-1);
            if(ind == -1){
                ans = Math.max(ans, m[i][1]);
                continue;
            }

            ans = Math.max(ans, m[i][1] + pre[ind]);
        }

        return ans;

        
    }

    private int search(int m[][], int req, int start, int end){
        int ind = -1;
        while(start <= end){
            int mid = (start + end)/2;

            if(m[mid][0] < req){
                ind = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ind;
    }
}