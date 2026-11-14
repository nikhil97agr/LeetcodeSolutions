package minimum_cost_to_make_arrays_identical_3712;

import java.util.*;
class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        long a1 = 0;
        long a2 = k;
        int n = arr.length;
        for(int i=0;i<n;i++){
            a1 += 1l *Math.abs(arr[i] - brr[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        for(int i=0;i<n;i++){
            a2 += 1l * Math.abs(arr[i] - brr[i]);
        }

        return Math.min(a1, a2);
    }
}