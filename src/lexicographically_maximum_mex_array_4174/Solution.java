package lexicographically_maximum_mex_array_4174;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int[] maximumMEX(int[] nums) {

        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int suff[] = new int[n];
        Set<Integer> vis = new HashSet<>();
        int mex = 0;
        for (int i = n - 1; i >= 0; i--) {
            vis.add(nums[i]);
            while (vis.contains(mex)) {
                mex++;
            }
            suff[i] = mex;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; ) {
            if (suff[i] == 0) {
                while (i < n) {
                    result.add(0);
                    i++;
                }
                break;
            }
            Set<Integer> set = new HashSet<>();
            max = suff[i];
            int val = 0;
            while (i < n && val < max) {
                if (nums[i] < max && !set.contains(nums[i])) {
                    val++;
                    set.add(nums[i]);
                }
                i++;
            }

            result.add(max);
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}