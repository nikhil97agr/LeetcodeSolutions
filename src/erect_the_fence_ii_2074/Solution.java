package erect_the_fence_ii_2074;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Solution {

    public double[] outerTrees(int[][] trees) {

        var points = new ArrayList<Point>();
        for (var t : trees) {
            points.add(new Point(t[0], t[1]));
        }

        Collections.sort(points, (a,b)->{
            double d1 = Math.hypot(a.x, a.y);
            double d2 = Math.hypot(b.x, b.y);
            if(d1 == d2) return 0;
            if(d1 < d2) return -1;
            return 1;
        });
        var n = trees.length;

        Circle circle = solve(points, new ArrayList<>(), n);

        return new double[]{circle.center.x, circle.center.y, circle.radius};
    }

    private Circle generateMinCircle(List<Point> boundary) {

        if (boundary.isEmpty()) {
            return new Circle(new Point(0, 0), 0);
        }

        if (boundary.size() == 1) {
            return new Circle(boundary.getFirst(), 0);
        }

        if (boundary.size() == 2) {
            return buildCircleFromPoints(boundary.getFirst(), boundary.getLast());
        }

        for (int i = 0; i < boundary.size(); i++) {
            for (int j = i + 1; j < boundary.size(); j++) {
                Circle circle = buildCircleFromPoints(boundary.get(i), boundary.get(j));
                if (circle.isValid(boundary)) {
                    return circle;
                }
            }
        }

        return buildCircleFromPoints(boundary.getFirst(), boundary.get(1), boundary.getLast());
    }

    private Point getCenter(double bx, double by, double cx, double cy) {

        double a = bx * bx + by * by;
        double b = cx * cx + cy * cy;
        double d = bx * cy - by * cx;
        return new Point((cy * a - by * b) / (2 * d), (bx * b - cx * a) / (2 * d));
    }

    private Circle buildCircleFromPoints(Point p1, Point p2, Point p3) {

        Point center = getCenter(p2.x - p1.x, p2.y - p1.y, p3.x - p1.x, p3.y - p1.y);

        center.x += p1.x;
        center.y += p1.y;

        return new Circle(center, center.dist(p1));


    }

    private Circle buildCircleFromPoints(Point p1, Point p2) {

        Point p = new Point((p1.x + p2.x) / 2d, (p1.y + p2.y) / 2d);

        return new Circle(p, p1.dist(p2) / 2d);
    }


    private Circle solve(List<Point> points, List<Point> boundary, int n) {

        if (n == 0 || boundary.size() == 3) {
            return generateMinCircle(boundary);
        }
        var randomIndex = new Random().nextInt(n);

        var point = points.get(randomIndex);
        Collections.swap(points, randomIndex, n - 1);

        Circle circle = solve(points, boundary, n - 1);
        if (point.inside(circle)) {
            return circle;
        }

        List<Point> newBoundary = new ArrayList<>(boundary);
        newBoundary.add(point);
        return solve(points, newBoundary, n - 1);
    }

    class Point {

        double x;
        double y;

        public Point(double x, double y) {

            this.x = x;
            this.y = y;
        }

        public boolean inside(Circle circle) {

            Point center = circle.center;
            double radius = circle.radius;
            double dist = this.dist(center);

            return dist <= radius;
        }

        public double dist(Point point) {

            return Math.hypot(this.x - point.x, this.y - point.y);
        }
    }

    class Circle {

        Point center;
        double radius;

        public Circle(Point center, double radius) {

            this.center = center;
            this.radius = radius;
        }

        public boolean isValid(List<Point> points) {

            for (var p : points) {
                if (!p.inside(this)) {
                    return false;
                }
            }

            return true;
        }
    }
}