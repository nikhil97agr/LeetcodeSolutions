import java.util.ArrayList;
import java.util.List;

class Solution {

    public int numPoints(int[][] darts, int r) {

        var n = darts.length;
        var points = new Point[n];
        for (var i = 0; i < n; i++) {
            points[i] = new Point(darts[i][0], darts[i][1]);
        }

        var dist = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                var p1 = points[i];
                var p2 = points[j];
                dist[i][j] = dist[j][i] = Math.hypot(p1.x - p2.x, p1.y - p2.y);
            }
        }
        var ans = 0;
        for (var i = 0; i < n; i++) {
            ans = Math.max(ans, getPointsInside(i, points, dist, r, n));
        }

        return ans;
    }

    private int getPointsInside(int ind, Point points[], double dist[][], int r, int n) {

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (ind == i || dist[ind][i] > 2 * r) {
                continue;
            }

            double angleB = Math.acos(dist[ind][i] / (2 * r));
            double angleA = Math.atan2(points[i].y - points[ind].y, points[i].x - points[ind].x);
            double start = angleA - angleB;
            double end = angleA + angleB;

            list.add(new Pair(start, true));
            list.add(new Pair(end, false));
        }

        list.sort((a, b) -> {
            if (a.first < b.first) {
                return -1;
            }
            if (a.first > b.first) {
                return 1;
            }

            return a.second ? -1 : 1;
        });

        int ans = 1;
        int cnt = 1;

        for(var pair : list){
            if(pair.second){
                cnt++;
            }else{
                cnt--;
            }
            
            ans= Math.max(ans, cnt);
        }
        
        return ans;
    }

    class Pair {

        double first;
        boolean second;

        public Pair(double first, boolean second) {

            this.first = first;
            this.second = second;
        }
    }

    class Point {

        int x;
        int y;

        public Point(int x, int y) {

            this.x = x;
            this.y = y;
        }
    }
}