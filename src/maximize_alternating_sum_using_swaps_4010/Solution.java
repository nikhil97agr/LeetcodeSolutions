package maximize_alternating_sum_using_swaps_4010;

import java.util.*;
class Solution {
    public long maxAlternatingSum(int[] nums, int[][] swaps) {
        int n = nums.length;
        int par[] = new int[n];

        for(int i=0;i<n;i++){
            par[i] = i;
        }
        long ans = 0;
        for(int s[] : swaps){
            int p1 = find(s[0], par);
            int p2 = find(s[1], par);

            if(p1 != p2){
                par[p1] = p2;
            }
        }

        Map<Integer, List<Integer>>  ind  = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> val = new HashMap<>();

        for(int i=0;i<n;i++){
            int p = find(i, par);

            ind.computeIfAbsent(p, x-> new ArrayList<>()).add(i);
            val.computeIfAbsent(p, x-> new PriorityQueue<>()).add(nums[i]);
        }

        for(int i : ind.keySet()){
            List<Integer> list = ind.get(i);
            PriorityQueue<Integer> que = val.get(i);

            for(int x : list){
                if(x%2==1){
                    ans -= que.poll();
                }
            }

            for(int x : list){
                if(x%2==0){
                    ans += que.poll();
                }
            }
        }

        return ans;
    }

    private int find(int x, int par[]){
        if(par[x] == x) return x;

        return par[x] = find(par[x], par);
    }
}