package split_with_minimum_sum_2650;

import java.util.*;
class Solution {
    public int splitNum(int num) {
        char c[] = (""+num).toCharArray();
        Arrays.sort(c);
        String r1 = "";
        String r2 = "";
        int i =0;
        while(i<c.length-1){
            r1 += c[i];
            r2 += c[i+1];
            i+=2;
        }
        
        if(c.length%2==1){
            r1 += c[c.length-1];
        }
        
        return Integer.parseInt(r1) + Integer.parseInt(r2);
        
    }
}