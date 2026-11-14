package longest_arithmetic_subsequence_of_given_difference_1330;

import java.util.*;
class Solution {
    public int longestSubsequence(int[] arr, int d) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int ans =0 ;
        for(int i=0;i<n;i++){
            map.put(arr[i], map.getOrDefault(arr[i]-d, 0)+1);
        }
        return map.values().stream().max(Integer::compare).orElse(0);
    }
}