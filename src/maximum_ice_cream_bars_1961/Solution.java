package maximum_ice_cream_bars_1961;

import java.util.*;
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for(int x : costs){
            if(x <= coins){
                count++;
                coins -= x;
            }
            else
            break;
        }
        return count;
    }
}