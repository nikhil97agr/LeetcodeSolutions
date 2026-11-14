package check_if_the_rectangle_corner_is_reachable_3478;

import java.util.*;
import java.util.LinkedList;

class Solution {
    public boolean canReachCorner(int xCorner, int yCorner, int[][] circles) {
        int n = circles.length;
        LinkedList<Integer> adjList[] = new LinkedList[n + 2];
        int m = n + 2;
        for (int i = 0; i < m; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int[] circle : circles) {
            if (intersect(circle, new int[]{0, 0, 0}) || intersect(circle, new int[]{xCorner, yCorner, 0}))
                return false;
        }

        for (int i = 0; i < n; i++) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            for (int j = i + 1; j < n; j++) {
                int x2 = circles[j][0];
                int y2 = circles[j][1];
                int r2 = circles[j][2];
                if (intersect(circles[i], circles[j])) {

                    if (x * r2 + x2 * r < (r + r2) * xCorner &&
                            y * r2 + y2 * r < (r + r2) * yCorner) {
                        adjList[i].add(j);
                        adjList[j].add(i);
                    }

                }
            }
        }
        /*
        n -> left edge;
        n+1 -> top edge;
        n+2 -> right edge;
        n+3 -> bottom edge;
         */
        for (int i = 0; i < n; i++) {
            long x = circles[i][0];
            long y = circles[i][1];
            long r = circles[i][2];
            if (x < -r || x > xCorner + r || y < -r || y > yCorner + r) continue;


            if (distToVerticalSegment(x, y, 0, 0, yCorner) <= r * r ||
                    distToHorizontalSegment(x, y, yCorner, 0, xCorner) <= r * r) {
                adjList[n].add(i);
                adjList[i].add(n);
            }

            if (distToVerticalSegment(x, y, xCorner, 0, yCorner) <= r * r ||
                    distToHorizontalSegment(x, y, 0, 0, xCorner) <= r * r) {
                adjList[n+1].add(i);
                adjList[i].add(n+1);
            }
            
            
        }
        return !dfs(n, n+1, adjList, new boolean[m]);

    }

    private long distToVerticalSegment(long x, long y, long xLine, long y1, long y2) {
        if (y < y1) {
            return (x - xLine) * (x - xLine) + (y - y1) * (y - y1);
        } else if (y > y2) {
            return (x - xLine) * (x - xLine) + (y - y2) * (y - y2);
        } else {
            return (x - xLine) * (x - xLine);
        }
    }

    private long distToHorizontalSegment(long x, long y, long yLine, long x1, long x2) {
        if (x < x1) {
            return (x - x1) * (x - x1) + (y - yLine) * (y - yLine);
        } else if (x > x2) {
            return (x - x2) * (x - x2) + (y - yLine) * (y - yLine);
        } else {
            return (y - yLine) * (y - yLine);
        }
    }

    private boolean dfs(int src, int dest, LinkedList<Integer> adjList[], boolean vis[]) {
        if (src == dest)
            return true;
        vis[src] = true;
        for (int child : adjList[src]) {
            if (!vis[child] && dfs(child, dest, adjList, vis)) {
                return true;
            }
        }

        return false;

    }

    private boolean intersect(int[] c1, int c2[]) {
        long x1 = c1[0], y1 = c1[1], r1 = c1[2];
        long x2 = c2[0], y2 = c2[1], r2 = c2[2];

        long distSquared = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        long sumRadii = r1 + r2;

        return distSquared <= sumRadii * sumRadii;
    }

}