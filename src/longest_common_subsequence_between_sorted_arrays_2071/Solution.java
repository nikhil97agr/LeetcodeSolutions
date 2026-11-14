package longest_common_subsequence_between_sorted_arrays_2071;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        for(int x : arrays[0]) result.add(x);
        int n = arrays.length;

        for(int i=1;i<n;i++){
            result = lcs(result.stream().mapToInt(x->x).toArray(), arrays[i]);
        }

        return result;
    }

    public List<Integer> lcs(int a[], int b[]){
        List<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<a.length && j < b.length){
            if(a[i] == b[j]){
                result.add(a[i]);
                i++;
                j++;
            }else if(a[i] > b[j]){
                j++;
            }else{
                i++;
            }
        }
        return result;
    }
}