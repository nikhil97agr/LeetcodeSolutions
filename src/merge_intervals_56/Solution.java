package merge_intervals_56;

import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res= new ArrayList<>();
        Arrays.sort(intervals, (i1,i2) -> {
            if(i1[0] == i2[0]) return i1[1] - i2[1];
            return i1[0] - i2[0];
        });
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<n;i++){
            if(intervals[i][0] > end){
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];

            }else{
                end = Math.max(end, intervals[i][1]);
            }
        }

        res.add(new int[]{start, end});


        return res.stream().toArray(int[][]::new);
    }
}