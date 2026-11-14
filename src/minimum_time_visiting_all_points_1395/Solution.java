package minimum_time_visiting_all_points_1395;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int i=0;
        int n = points.length;
        int total =0;
        while(i<n-1){
            int p1[] = points[i];
            int p2[] = points[i+1];
            int h = Math.abs(p1[0] - p2[0]);
            int v = Math.abs(p1[1] - p2[1]);
            total += Math.max(h,v);
            i++;
        }
        return total;
    }
}