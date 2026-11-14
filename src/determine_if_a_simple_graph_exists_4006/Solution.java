package determine_if_a_simple_graph_exists_4006;

import java.util.*;
class Solution {
    public boolean simpleGraphExists(int[] degrees) {
        Arrays.sort(degrees);
        int n = degrees.length;
        long total = 0;
        for(int x : degrees) total += x;

        if((total & 1) == 1) return false;

        long s1 = 0;


        for(int i=n-1,j=n-1, k=1;i >=0; i--,k++){
            s1 += degrees[i];
            while(j >=i || (j >=0 && degrees[j] >k)){
                total -= degrees[j--];
            }

            long s2 =  1l*(i-j-1)*k;

            if(s1 > 1l*k*(k-1) + s2 + total){
                return false;
            }
        }

        return true;
    }
}