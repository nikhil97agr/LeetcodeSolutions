package mark_elements_on_array_by_performing_queries_3306;

import java.util.*;
class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        long ans[] = new long[m];
        long total = 0;
        for(int x : nums){
            total += 1L*x;
        }
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->{
            if(nums[a] == nums[b]){
                return a-b;
            }
            return nums[a] - nums[b];
        });
        for(int i=0;i<n;i++){
            que.offer(i);
        }
        boolean vis[] = new boolean[n];
        for(int i=0;i<m;i++){
                    long sum = 0;

            int k = queries[i][1];
            int ind = queries[i][0];
            if(!vis[ind]){
                vis[ind] = true;
                sum += 1L*nums[ind];
                
                
            }
            while(!que.isEmpty() && k > 0){
                 ind = que.poll();
                if(!vis[ind]){
                    vis[ind] = true;
                    k--;
                    sum += 1L*nums[ind];
                }
                
            }
            total -= sum;
            ans[i] = total;
        }
        return ans;
    }
}