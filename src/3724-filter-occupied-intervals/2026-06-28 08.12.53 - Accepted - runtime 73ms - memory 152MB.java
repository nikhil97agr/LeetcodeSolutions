import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] intervals, int freeStart, int freeEnd) {
        Arrays.sort(intervals, (a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            } 
            return a[0] - b[0];
        });

        Queue<int[]> que = new LinkedList<>();
        var start = intervals[0][0];
        var end = intervals[0][1];
        int n = intervals.length;
        for(int i=1;i<n;i++){
            int next[] = intervals[i];
            
            if(next[0] > end + 1){
                que.offer(new int[]{start, end});
                start = next[0];
                end = next[1];
                continue;
            }
            end= Math.max(end, next[1]);
            
        }
        
        que.offer(new int[]{start , end});
        
        List<List<Integer>> result = new ArrayList<>();

        while (!que.isEmpty()) {
            var next = que.poll();
            
            if(freeStart <= next[0] && next[1] <= freeEnd){
                continue;
            }
            
            if(freeEnd < next[0]){
                result.add(Arrays.asList(next[0], next[1]));
                continue;
            }
            
            if(freeStart > next[1]){
                result.add(Arrays.asList(next[0], next[1]));
                continue;
            }
            
            if(next[0] < freeStart){
                add(result, next[0], freeStart - 1);
                if(freeEnd < next[1]){
                    add(result, freeEnd + 1, next[1]);
                }
            }else{
                add(result, freeEnd + 1, next[1]);
            }
        }
        
        return result;
    }
    
    private void add(List<List<Integer>> list, int start , int end){
        list.add(Arrays.asList(start, end));
    }
}