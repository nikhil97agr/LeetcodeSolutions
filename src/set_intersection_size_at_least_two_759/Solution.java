package set_intersection_size_at_least_two_759;

import java.util.*;
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if(a[1] == b[1]){
                return b[0] - a[0];
            }

            return a[1] - b[1];
        });

        int res = 0;
        int start =-1;
        int end = -1;

        for(int i[] : intervals){
            int s = i[0];
            int e = i[1];

            if(s > end){
                res += 2;
                start = e - 1;
                end = e;
            }else if(s > start){
                res++;
                start = end;
                end = e;
            }
        }

        return res;
    }
}