package maximum_area_of_a_piece_of_cake_after_horizontal_and_vertical_cuts_1575;

import java.util.*;
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long l = 0;
        long b = 0;
        long prev = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for(int x : horizontalCuts){
            l = Math.max(l, x - prev);
            prev = x;
        }
        l = Math.max(l, h - prev);

        prev = 0;
        for(int x : verticalCuts){
            b = Math.max(b, x - prev);
            prev = x;
        }
        b = Math.max(b, w - prev);

        long mod = (long)(1e9+7);

        return (int)((l*b)%mod);
    }
}