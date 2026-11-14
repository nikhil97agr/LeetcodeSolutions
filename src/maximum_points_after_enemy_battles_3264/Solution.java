package maximum_points_after_enemy_battles_3264;

import java.util.*;
class Solution {
    public long maximumPoints(int[] arr, int n) {
        long ans = 0;
        Arrays.sort(arr);
        long en = 1L*n;
        int j=arr.length-1;
        while(j >= 0){
            
            if(en >= 1L*arr[0]){
                long x=  en / (1L*arr[0]);
                ans += x;
                en = en%(1L*arr[0]);
            }
            if(ans == 0){
                return ans;
            }
            en += 1L*arr[j];
            j--;
        }
        return ans;
    }
}