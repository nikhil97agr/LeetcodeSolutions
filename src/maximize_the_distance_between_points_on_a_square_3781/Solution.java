package maximize_the_distance_between_points_on_a_square_3781;

import java.util.*;
import java.util.Arrays;

class Solution {

    public int maxDistance(int side, int[][] points, int k) {

        var n = points.length;
        var perimeter = 4l * side;
        var positions = new long[n];
        for (var i = 0; i < n; i++) {
            var p = points[i];
            var x = p[0];
            var y = p[1];

            if (x == 0) {
                positions[i] = perimeter - y;
            } else if (y == 0) {
                positions[i] = x;
            } else if (y == side) {
                positions[i] = 3l * side - x;
            } else {
                positions[i] = side + y;
            }
        }

        var extended = new long[2 * n];
        var ind = 0;
        Arrays.sort(positions);
        for (int i = 0; i < n; i++) {
            extended[ind++] = positions[i];
        }

        for (int i = 0; i < n; i++) {
            extended[ind++] = positions[i] + perimeter;
        }

        var ans = 0l;
        var start = 0l;
        var end = 2l * side;

        while (start <= end) {
            var mid = start + (end - start) / 2;

            if (check(mid, extended, perimeter, n, k)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) ans;
    }

    private boolean check(long mid, long extended[], long perimeter, int n, int k) {

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            long prev = extended[i];
            int prevStart = i;
            while(cnt < k && prevStart < i + n){
                int start = prevStart + 1;
                int end = i + n -1;
                int ind = -1;
                while(start <= end){
                    int m = (start + end)/2;
                    if(extended[m] - prev >= mid){
                        ind = m;
                        end = m - 1;
                    }else{
                        start = m + 1;
                    }
                }
                
                if(ind == -1){
                    break;
                }
                
                prev = extended[ind];
                prevStart = ind;
                cnt++;
                
                
            }

            if (cnt >= k && extended[i] + perimeter - prev >= mid) {
                return true;
            }
        }

        return false;
    }
}