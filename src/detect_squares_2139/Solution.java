package detect_squares_2139;

import java.util.*;
class DetectSquares {

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object obj){
            Point p = (Point)obj;
            return p.x == x && p.y==y;
        }


        public int hashCode(){
            return (""+x+":"+y).hashCode();
        }
    }
    Map<Point, Integer> map;
    public DetectSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);
        map.put(p, map.getOrDefault(p, 0)+1);
    }
    
    public int count(int[] point) {
        int ans = 0;
        Point pnt = new Point(point[0], point[1]);
        for(Point p : map.keySet()){
            if(p.x == pnt.x  || p.y == pnt.y) continue;
            if(Math.abs(p.x - pnt.x) == Math.abs(p.y - pnt.y)){
                Point p1 = new Point(p.x, pnt.y);
                Point p2 = new Point(pnt.x, p.y);

                if(map.containsKey(p1) && map.containsKey(p2)){
                    
                    ans += map.get(p)*map.get(p1)*map.get(p2);
                }
            }
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */