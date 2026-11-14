package fair_candy_swap_924;

import java.util.*;
class Solution {
    public int[] fairCandySwap(int[] a, int[] b) {
        int totala = 0;
        for(int x : a){
            totala += x;
        }
        int totalb=0;
        Set<Integer> set = new HashSet<>();
        for(int x : b){
            set.add(x);
            totalb += x;
        }
        
        if(totala > totalb){
            int diff = (totala - totalb)/2;
            for(int x : a){
                int req = x - diff;
                if(set.contains(req)){
                    return new int[]{x, req};
                }
            }
        }else{
            int diff = (totalb - totala)/2;

            for(int x : a){
                int req = x + diff;
                if(set.contains(req)){
                    return new int[]{x, req};
                }
            }
        }

        return new int[]{0,0};
    }
}