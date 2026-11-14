package number_of_different_subsequences_gcds_1947;

import java.util.*;
class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        boolean present[]= new boolean[max + 1];

        for(int x : nums) present[x] = true;

        for(int i=1;i<=max;i++){
            int gcd = 0;
            for(int j=i;j<=max;j+=i){
                if(present[j]){
                    if(j==i){
                        ans++;
                        break;
                    }
                    gcd = gcd(gcd, j);
                }

                if(gcd == i){
                    ans++;
                    break;
                }
            }

        }
        return ans;
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}