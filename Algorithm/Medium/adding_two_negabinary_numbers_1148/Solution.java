package adding_two_negabinary_numbers_1148;

import java.util.*;
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int n = Math.max(arr1.length, arr2.length) + 2;
        int ans[]= new int[n];
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = n - 1;
        while(i >=0 || j >=0 || k >=0){
            int total = 0;
            if(i >=0) total += arr1[i];
            if(j >=0) total += arr2[j];
            total += ans[k];

            if(total == 1){
                ans[k] = 1;
            }else if(total == 2){
                ans[k] = 0;
                if(k-1 >=0) ans[k-1]++;
                if(k-2 >=0) ans[k-2]++;
            }else if(total == 3){
                ans[k] = 1;
                if(k-1 >=0) ans[k-1]++;
                if(k-2 >=0) ans[k-2]++;
            }else if(total == 4){
                ans[k] = 0;
                if(k-2 >=0) ans[k-2]++;
            }

            i--;
            j--;
            k--;
        }
        int zeroIndex = 0;
        while(zeroIndex < n && ans[zeroIndex]==0) zeroIndex++;
        ans = Arrays.copyOfRange(ans, zeroIndex, n);

        if(ans.length == 0) return new int[]{0};
        return ans;
    }
}