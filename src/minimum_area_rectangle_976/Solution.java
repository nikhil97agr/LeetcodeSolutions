package minimum_area_rectangle_976;

import java.util.*;
class Solution {
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o){
            Point p = (Point) o;
            return p.x ==x && p.y ==y;
        }

        public String toString(){
            return ""+x+":"+y;
        }

        public int hashCode(){
            return (""+x+":"+y).hashCode();
        }
    }
    public int minAreaRect(int[][] points) {
        Set<Point> set = new HashSet<>();
        int n = points.length;
        Point point[] = new Point[n];
        for(int i=0;i<n;i++){
            int p[] = points[i];
            point[i] = new Point(p[0], p[1]);
            set.add(new Point(p[0], p[1]));
        }
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(!parallel(point[i], point[j])){
                    Point p1 = new Point(point[i].x, point[j].y);
                    Point p2 = new Point(point[j].x, point[i].y);
                    if(set.contains(p1) && set.contains(p2)){
                        int area = Math.abs(point[i].x - point[j].x)* Math.abs(point[i].y - point[j].y);
                        ans = Math.min(ans, area);
                    }
                    
                }
            }
        }

        return ans == Integer.MAX_VALUE? 0 : ans;
    }

    private boolean parallel(Point p1, Point p2){
        return p1.x==p2.x || p1.y==p2.y;
    }
}