package minimum_time_to_complete_trips_2294;

import java.util.*;
class Solution {
    
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 1;
        int n = time.length;
        long right = 1l*totalTrips*time[n-1];
        while(left<right){
            long mid = (left+right)/2;
            long total = 0;
            for(int x : time){
                total += 1l*mid/x;
            }
            if(total >=totalTrips){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}