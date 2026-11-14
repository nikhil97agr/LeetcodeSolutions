package maximum_calories_burnt_from_jumps_4109;

import java.util.*;
class Solution {
    public long maxCaloriesBurnt(int[] heights) {
        Arrays.sort(heights);
        int n = heights.length ;
        long ans = 0;
        int prev = 0;
        int start = 0;
        int end = n-1;

        while(start <= end){
            ans += Math.pow(prev - heights[end], 2);
            prev = heights[end];
            end--;
            if(start <= end){
                ans += Math.pow(prev - heights[start], 2);
                prev = heights[start];
                start++;
            }
        }

        return ans;
    }
}