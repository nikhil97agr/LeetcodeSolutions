package magnetic_force_between_two_balls_1675;

import java.util.*;
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int start = 0;
        int end = position[n-1] - position[0];
        int ans = 0;
        while(start <= end){
            int mid = (start+end)>>1;

            int min = Integer.MAX_VALUE;
            int prev = position[0];
            int balls = m-1;
            for(int i=1;i<n;i++){
                if(position[i] - prev >= mid){
                    min = Math.min(min, position[i] - prev);
                    balls--;
                    prev = position[i];
                }
                if(balls == 0) break;
            }
            if(balls==0){
                ans = Math.max(ans, min);
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
}