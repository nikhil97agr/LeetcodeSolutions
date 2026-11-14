package find_the_integer_added_to_array_i_3397;

import java.util.*;
class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int x = nums2[0] - nums1[0];
        return x;
    }
}