package queries_on_number_of_points_inside_a_circle_1939;

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;

        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];

            for(int p[] : points){
                ans[i] += check(x, y, r, p);
            }
        }

        return ans;
    }

    private int check(int x, int y, int r, int p[]){
        int dist = (int)Math.pow(x-p[0],2) + (int)Math.pow(y-p[1], 2);

        r = r*r;

        int diff = dist - r;

        return diff <=0 ? 1 : 0;
    }
}