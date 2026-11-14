package separate_squares_i_3763;

import java.util.*;
class Solution {
    public double separateSquares(int[][] squares) {
        List<int[]> list = new ArrayList<>();
        int n= squares.length;
        long totalArea = 0;
        for(int sq[] : squares){
            int y =sq[1];
            int l = sq[2];

            list.add(new int[]{y, l, 1});
            list.add(new int[]{y+l, l, -1});
            totalArea += 1l*l*l;
        }

        Collections.sort(list, (a,b) -> a[0] - b[0]);
        double area = 0;
        double prevHeight = 0;
        double width = 0;
        for(int next[] : list){
            int y = next[0];
            int l = next[1];
            int flag = next[2];

            double nextHeight = y - prevHeight;
            double currArea = width * nextHeight;

            if(2l*(currArea + area) >= totalArea){
                return prevHeight + (totalArea - 2*area)/ (2*width);
            }

            width += flag*l;
            area += currArea;
            prevHeight = y;
        }
        

        return 0d;

    }
}