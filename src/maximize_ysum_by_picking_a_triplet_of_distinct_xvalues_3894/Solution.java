package maximize_ysum_by_picking_a_triplet_of_distinct_xvalues_3894;

import java.util.*;
class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;

        int p[][] = new int[n][2];
        for(int i=0;i<n;i++){
            p[i] = new int[]{i, y[i]};
        }

        Arrays.sort(p, (p1, p2) -> p2[1] - p1[1]);
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> vis = new HashSet<>();
        for(int i=0;i<n;i++){
            int val = p[i][1];
            int ind = p[i][0];

            if(!vis.contains(x[ind])){
                que.offer(val);
                vis.add(x[ind]);
            }
        }
        if(que.size() < 3)
        return -1;

        return que.poll() + que.poll() + que.poll();
    }
}