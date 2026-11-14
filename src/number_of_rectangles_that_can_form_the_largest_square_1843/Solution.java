package number_of_rectangles_that_can_form_the_largest_square_1843;

import java.util.*;
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int rect[] : rectangles){
            int l = rect[0];
            int w = rect[1];

            int min = Math.min(l,w);

            map.merge(min, 1, Integer::sum);
        }

        return map.lastEntry().getValue();
    }
}