package minimum_relative_loss_after_buying_chocolates_3077;

import java.util.*;
class Solution {
    public long[] minimumRelativeLosses(int[] prices, int[][] queries) {
        Arrays.sort(prices);
        int n = prices.length;
        long ans[] = new long[queries.length];
        long pre[] = new long[n+1];
        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1] + prices[i-1];
        }
        int q= queries.length;
        int queryInd[] = new int[queries.length];
        for(int i=0;i<q;i++){
            queryInd[i] = i;
        }

        queryInd = Arrays.stream(queryInd).boxed().sorted((a,b) -> queries[a][0] - queries[b][0])
        .mapToInt(x -> x).toArray();

        int end = 0;
        for(var i : queryInd){
            int k = queries[i][0];
            int m = queries[i][1];
            long d = (1l * k) << 1;
            while( end < n && prices[end] <= k){
                end++;
            }
            int min = Math.min(end, m);
            int left = 1;
            int right = Math.min(min, n - m);
            while(left <= right){
                int mid = (left + right)>>1;
                if(prices[min- mid] > d - prices[n - (m - min) - mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

            min -= (left - 1);
            int n2 = m - min;
            ans[i] = d * n2 - (pre[n] - pre[n - n2]) + pre[min];
        }

        return ans;
    }
}