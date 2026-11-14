package minimum_cost_for_cutting_cake_ii_3500;

import java.util.*;
import java.util.Arrays;

class Solution {


    public long minimumCost(int m, int n, int[] hcost, int[] vcost) {
        Arrays.sort(hcost);
        Arrays.sort(vcost);
        long ans  = 0;
        long h = 1;
        long v = 1;
        int i=hcost.length-1;
        int j=vcost.length-1;

        while(i>=0 && j >=0){
            if(hcost[i] > vcost[j]){
                ans += v*hcost[i];
                i--;
                h++;
            }else{
                ans += h*vcost[j];
                j--;
                v++;
            }
        }

        while(i>=0){
            ans += v*hcost[i];
            i--;
        }

        while(j>=0){
            ans += h*vcost[j];
            j--;
        }

        return ans;
    }


}