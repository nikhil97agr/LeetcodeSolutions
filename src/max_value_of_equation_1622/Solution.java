package max_value_of_equation_1622;

import java.util.*;
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]); // max (y - x)

        int ans = Integer.MIN_VALUE;

        for (int[] p : points) {
            int x = p[0], y = p[1];

            while (!pq.isEmpty() && x - pq.peek()[1] > k) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                ans = Math.max(ans, pq.peek()[0] + y + x);
            }

            pq.offer(new int[]{y - x, x});
        }
        return ans;
    }
}
