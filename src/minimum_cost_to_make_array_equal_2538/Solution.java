package minimum_cost_to_make_array_equal_2538;

import java.util.*;
class Solution {
    class Node{
        long num;
        long cost;
        public Node(long num, long cost){
            this.num = num;
            this.cost = cost;
        }
        
    }
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        Node nodes[] = new Node[n];
        for(int i=0;i<n;i++){
            nodes[i] = new Node((long)nums[i], (long)cost[i]);
        }
        Arrays.sort(nodes, (n1, n2)->{
            if(n1.num>n2.num){
                return 1;
            }
            return -1;
        });
        long forward[] = new long[n];
        long backward[] = new long[n];
        forward[0] = 0L;
        backward[n-1] = 0L;
        long c = 0L;
        for(int i=1;i<n;i++){
            c += nodes[i-1].cost;
            forward[i] = forward[i-1]+(long)Math.abs(nodes[i].num-nodes[i-1].num)*c;
        }
        c= 0L;
        for(int i=n-2;i>=0;i--){
            c += nodes[i+1].cost;
            backward[i] += backward[i+1]+(long)Math.abs(nodes[i].num-nodes[i+1].num)*c;
        }
        long ans = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(ans, forward[i]+backward[i]);
            
        }
        return ans;
    }
}