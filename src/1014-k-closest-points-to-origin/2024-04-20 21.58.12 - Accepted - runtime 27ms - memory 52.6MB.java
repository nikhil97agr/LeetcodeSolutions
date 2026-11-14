class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a,b)->{
            int dist1 = a[0]*a[0] + a[1]*a[1];
            int dist2 = b[0]*b[0] + b[1]*b[1];

            if(dist1 <= dist2) return -1;
            return 1;
        });
        int ans[][] = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i] = points[i];
        }

        return ans;
    }
}