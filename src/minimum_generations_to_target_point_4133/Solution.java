package minimum_generations_to_target_point_4133;

import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int minGenerations(int[][] points, int[] target) {

        int len = 344;
        int targetH = hash(target[0], target[1], target[2]);
        int max = Integer.MAX_VALUE;
        int dist[] = new int[len + 1];
        Arrays.fill(dist, max);
        for (int i = 0; i < points.length; i++) {
            int h = hash(points[i][0], points[i][1], points[i][2]);
            dist[h] = 0;
        }
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i <= len; i++) {
            if (dist[i] == 0) {
                pq.offer(new int[]{i, dist[i]});
            }
        }

        while (!pq.isEmpty()) {
            int next[] = pq.poll();

            int id = next[0];
            int d = next[1];
            if (dist[id] != d) {
                continue;
            }
            int c1[] = val(id);
            for (int i = 0; i <= len; i++) {
                if (i == id || dist[i] == max) {
                    continue;
                }

                int c2[] = val(i);

                int x1 = (c1[0] + c2[0]) / 2;
                int y1 = (c1[1] + c2[1]) / 2;
                int z1 = (c1[2] + c2[2]) / 2;

                int newId = hash(x1, y1, z1);

                int dd = Math.max(dist[i], dist[id]) + 1;

                if (dd < dist[newId]) {
                    dist[newId] = dd;
                    pq.offer(new int[]{newId, dd});
                }
            }
        }

        if (dist[targetH] == max) {
            return -1;
        }

        return dist[targetH];
    }

    int hash(int a, int b, int c) {

        return a * 49 + b * 7 + c;
    }

    int[] val(int hash) {

        int x = hash / 49;
        hash %= 49;
        int y = hash / 7;
        int z = hash % 7;

        return new int[]{x, y, z};
    }
}