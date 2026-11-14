package largest_triangle_area_830;

class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0d;

        int n = points.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }

        return ans;
    }

    private double area(int p1[], int p2[], int p3[]){
        int x1 = p1[0], x2 = p2[0], x3 = p3[0];
        int y1 = p1[1], y2 = p2[1], y3 = p3[1];

        double area = (1d*Math.abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)))/2;
        return area;
    }
}