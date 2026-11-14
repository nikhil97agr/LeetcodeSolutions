package mice_and_cheese_2725;

import java.util.*;
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int cheez[][] = new int[n][2];
        for(int i=0;i<n;i++){
            cheez[i] = new int[]{reward1[i], reward2[i]};
        }

        Arrays.sort(cheez, (a,b)->{
            int s1 = a[0] + b[1];
            int s2 = b[0] + a[1];

            return s2 - s1;
        });
        int ans = 0;
        int i=0;
        while(i < k){
            ans += cheez[i][0];
            i++;
        }

        while(i < n){
            ans += cheez[i][1];
            i++;
        }

        return ans;
    }
}