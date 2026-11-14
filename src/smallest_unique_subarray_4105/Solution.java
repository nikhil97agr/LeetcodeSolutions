package smallest_unique_subarray_4105;

import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    int m1 = (int) 1e9 + 7;
    int m2 = (int) 1e9 + 9;
    int p = 1_000_003;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;
        int ans = n;

        int start = 1;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (duplicate(nums, mid, n)) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;

    }

    private boolean duplicate(int nums[], int len, int n) {

        Map<String, Integer> map = new HashMap<>();

        int h1 = 0;
        int h2 = 0;
        int p1 = pow(p, len - 1, m1);
        int p2 = pow(p, len - 1, m2);

        for (int i = 0, j = 0; i < n; i++) {
            h1 = add(prod(h1, p, m1), nums[i], m1);
            h2 = add(prod(h2, p, m2), nums[i], m2);

            if (i >= len - 1) {
                String h = h1 + ":" + h2;
                map.merge(h, 1, Integer::sum);



                h1 = add(h1, -prod(p1, nums[j], m1), m1);
                h2 = add(h2, -prod(p2, nums[j], m2), m2);

                j++;
            }
        }

       int min = map.values().stream().min(Integer::compareTo).get();
        
        return min > 1;
    }

    private int pow(int a, int b, int m) {

        int ans = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ans = prod(ans, a, m);
            }

            a = prod(a, a, m);
            b >>= 1;
        }
        return ans;
    }

    private int add(int a, int b, int m) {

        long s = (1l * a + b + m);

        return (int) (s % m);
    }

    private int prod(int a, int b, int m) {

        long p = 1l * a * b;

        return (int) (p % m);
    }
}