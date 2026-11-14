package find_common_elements_between_two_arrays_3206;

import java.util.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        return new int[]{cnt(nums1, nums2), cnt(nums2, nums1)};
    }

    private int cnt(int a1[], int a2[]){
        Set<Integer> set = Arrays.stream(a2).boxed().collect(Collectors.toSet());
        
        
        return (int) Arrays.stream(a1).filter(set::contains).count();


    }
}