package find_nearest_point_that_has_the_same_x_or_y_coordinate_1888;

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = Integer.MAX_VALUE;
        int ind = -1;
        int n = points.length;
        for(int i =0;i<n;i++){

            if(x==points[i][0] || y==points[i][1]){
                int dist = Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);
                if(ans > dist){
                    ans = dist;
                    ind = i;
                }
            }
        }

        return ind;
    }

}