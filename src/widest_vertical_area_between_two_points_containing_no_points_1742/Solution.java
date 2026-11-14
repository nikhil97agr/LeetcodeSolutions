package widest_vertical_area_between_two_points_containing_no_points_1742;

import java.util.*;
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {


        int[] list = new int[points.length];

        for (int i=0; i<points.length;i++){
            list[i]=points[i][0];
        }

        Arrays.sort(list);

        int max = Integer.MIN_VALUE;

        for (int i=list.length-1; i>0;i--){
            if ((list[i]-list[i-1])>max){
                max=list[i]-list[i-1];
            }
        }

        return max;

        
    }
}