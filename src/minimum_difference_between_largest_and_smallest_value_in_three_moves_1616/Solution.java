package minimum_difference_between_largest_and_smallest_value_in_three_moves_1616;

import java.util.*;
class Solution {
    public int minDifference(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        if(arr.length <= 4) return 0;
        Arrays.sort(arr);
        int minDiff = max - min;
        int cnt = 3;
        int n = arr.length;
        for(int i=0;i<=cnt;i++){
            minDiff = Math.min(Math.abs(arr[i] - arr[n-1-(cnt-i)]), minDiff);
        }

        return minDiff;
    }
}