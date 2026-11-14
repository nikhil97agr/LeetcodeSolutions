package remove_covered_intervals_1222;

import java.util.*;
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1,i2)->{
            if(i1[0] == i2[0]) return i1[1] - i2[1];
            return i1[0] - i2[0];
        });

        Stack<int[]> stack =new Stack<>();
        stack.push(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            while(!stack.isEmpty()){
                if(check(stack.peek(), intervals[i])){
                    stack.pop();
                }else if(check(intervals[i], stack.peek())){
                    break;
                }else{
                    stack.push(intervals[i]);
                    break;
                }
            }
            if(stack.isEmpty()){
                stack.push(intervals[i]);
            }
        }
        return stack.size();
    }

    private boolean check(int i1[], int i2[]){
        return i2[0] <= i1[0] && i1[1] <= i2[1];
    }
}