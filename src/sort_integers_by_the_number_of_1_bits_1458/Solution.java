package sort_integers_by_the_number_of_1_bits_1458;

import java.util.*;
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int count[][] = new int[n][2];
        for(int i=0;i<n;i++){
            count[i][1] =arr[i];
            int x= arr[i];
            while(x>0){
                int digit = x%2;
                count[i][0] += digit;
                x/=2;
            }
        }

        Arrays.sort(count, (a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
 
        int result[] = new int[n];
        for(int i=0;i<n;i++){
            result[i] = count[i][1];
        }

        return result;
    }

}