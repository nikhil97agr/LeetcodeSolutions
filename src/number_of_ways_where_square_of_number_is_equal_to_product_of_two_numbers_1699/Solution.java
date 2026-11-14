package number_of_ways_where_square_of_number_is_equal_to_product_of_two_numbers_1699;

import java.util.*;
class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return cnt(nums1, nums2) + cnt(nums2, nums1);
    }

    private int cnt(int a[], int b[]){
        Map<Long, Integer> map = new HashMap<>();

        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                map.merge(1l*a[i]*a[j], 1, Integer::sum);
            }
        }

        int ans = 0;

        for(int x : b){
            long prod = 1l*x*x;
            ans += map.getOrDefault(prod, 0);

        }
        return ans;
    }
}