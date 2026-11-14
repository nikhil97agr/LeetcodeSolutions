package subtree_inversion_sum_ii_3874;

import java.util.*;
class Solution {
    int nums[];
    List<Integer> adjList[];
    int k;
    public int subtreeInversionSum(int[][] edges, int[] nums, int k) {
        this.k = k;
        adjList = new ArrayList[nums.length];
        this.nums = nums;
        for(int i=0;i<nums.length;i++){
            adjList[i] = new ArrayList<>();
        }

        for(var e : edges){
            var u = e[0];
            var v = e[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        return (int)(dfs(0, -1).max[0]);
    }

    public Pair dfs(int curr, int par){
        long max[] = new long[k];
        long min[] =new long[k];
        Arrays.fill(max, nums[curr]);
        Arrays.fill(min, nums[curr]);

        for(int child : adjList[curr]){
            if(child == par) continue;

            Pair childRes = dfs(child, curr);

            long cMax[] = childRes.max;
            long cMin[] = childRes.min;

            for(int i=0;i<k/2;i++){
                max[i] = Math.max(max[i] + cMax[k - i - 2], max[k - i - 2] + cMax[i]);

                min[i] = Math.min( min[i] + cMin[k - i- 2], min[k - i - 2] + cMin[i]);
            }

            for(int i=k/2;i<k;i++){
                min[i] += cMin[i];
                max[i] += cMax[i];

            }

            for(int i=k-2;i>=0;i--){
                min[i] = Math.min(min[i], min[i+1]);
                max[i] = Math.max(max[i], max[i+1]);
            }
        }

        long rMin[] = new long[k];
        long rMax[] = new long[k];
        rMin[0] = Math.min(min[0], -max[k-1]);
        rMax[0] = Math.max(max[0], -min[k-1]);

        for(int i=1;i<k;i++){
            rMin[i] = min[i-1];
            rMax[i] = max[i-1];
        }

        return new Pair(rMax, rMin);
    }


    class Pair{
        long max[];
        long min[];

        public Pair(long max[], long min[]){
            this.max = max;
            this.min = min;
        }
    }

}