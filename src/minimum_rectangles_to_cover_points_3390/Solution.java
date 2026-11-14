package minimum_rectangles_to_cover_points_3390;

import java.util.*;
class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (p1, p2)-> p1[0] - p2[0]);
        int ans = 0;
        int start = points[0][0];
        for(int p[] : points){
            if(p[0] - start > w){
                ans++;
                start = p[0];
            }
        }
        ans++;
        return ans;
    }
}