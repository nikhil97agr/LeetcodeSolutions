package count_ways_to_group_overlapping_ranges_2651;

import java.util.*;
class Solution {
    
    class Range{
        int start;
        int end;
        public Range(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        public String toString(){
return ""+start+":"+end;
        }
    }
    public int countWays(int[][] ranges) {
        
        Arrays.sort(ranges, (a,b)->{
            if(a[0]==b[0]){
                return a[1] - b[1];
            }
            return a[0]-b[0];
        });
        
        Stack<Range> stack = new Stack<>();
        for(int range[] : ranges){
            Range r = new Range(range[0], range[1]);
            if(stack.isEmpty()){
                stack.add(r);
            }else{
                if(isOverlap(r, stack.peek())){
                    Range temp = stack.pop();
                    r.start = Math.min(r.start , temp.start);
                    r.end = Math.max(r.end , temp.end);
                    stack.push(r);
                }else{
                    stack.push(r);
                }
            }
        }
        
        int n = stack.size();
        long mod = (long)1E9+7;
        long ans = 1;
        for(int i=1;i<=n;i++){
            ans = ans*2;
            ans %=mod;
        }
        
        return (int)(ans%mod);
    }
    
    
    private boolean isOverlap(Range r1, Range r2){
        if(r1.start>= r2.start && r1.start <= r2.end){
            return true;
        }
        
        if(r1.end <= r2.end && r1.end >= r2.start){
            return true; 
        }
        
        if(r2.start <= r1.end && r2.start >= r1.start){
            return true;
        }
        if(r2.end <= r1.end && r2.end >=  r1.start){
            return true;
        }
        return false;
    }
}