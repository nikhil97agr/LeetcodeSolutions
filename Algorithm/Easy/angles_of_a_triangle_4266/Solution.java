package angles_of_a_triangle_4266;

import java.util.*;
import java.util.Arrays;

class Solution {

    public double[] internalAngles(int[] sides) {

        Arrays.sort(sides);
        var a = sides[0];
        var b = sides[1];
        var c = sides[2];

        if (a + b <= c) {
            return new double[0];
        }

        double A = Math.toDegrees(Math.acos((b*b + c*c - a*a) / (2.0 * b * c)));
        double B = Math.toDegrees(Math.acos((a*a + c*c - b*b) / (2.0 * a * c)));
        double C = Math.toDegrees(Math.acos((a*a + b*b - c*c) / (2.0 * a * b)));
        
        double res[] = new double[]{A,B,C};
        
        Arrays.sort(res);
        return res;
    }
}