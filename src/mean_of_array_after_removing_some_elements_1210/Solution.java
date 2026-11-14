package mean_of_array_after_removing_some_elements_1210;

import java.util.*;
class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int perc = (5*n)/100;

        int sum = 0;
        for(int i=perc;i<n-perc;i++){
            sum += arr[i];
        }


        return (1d*sum)/(n - 2*perc);
    }
}