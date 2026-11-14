package maximize_area_of_square_hole_in_grid_3214;

import java.util.*;
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int hCount = 1;
        int vCount = 1;
        int count = 1;
        int cur = hBars[0];
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        hCount = getCount(hBars);
        vCount = getCount(vBars);
        
        int min = Math.min(hCount, vCount)+1;
        
        return min*min;
    }
    
    private int getCount(int []bars){
        int res = 1;
        int count = 1;
        int cur = bars[0];
        for(int i=1;i<bars.length;i++){
            if(bars[i] == cur+1){
                count++;
                cur = bars[i];
            }else{
                res = Math.max(res, count);
                count = 1;
                cur = bars[i];
            }
        }
        res = Math.max(res, count);
        return res;
    }
}