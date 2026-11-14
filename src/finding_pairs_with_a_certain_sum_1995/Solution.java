package finding_pairs_with_a_certain_sum_1995;

import java.util.*;
class FindSumPairs {
    int arr[];
    int arr2[];
    Map<Integer, Integer> map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        arr = nums1;
        arr2 = nums2;
        map = new HashMap<>();
        for(int x : nums2){
            map.merge(x, 1, Integer::sum);
        }
    }
    
    public void add(int index, int val) {
        int v = arr2[index];
        int newV = val + v;

        arr2[index] = newV;
        map.merge(v, -1, Integer::sum);
        map.merge(newV, 1, Integer::sum);
    }
    
    public int count(int total) {
        int ans = 0;
        for(int x : arr){
            ans += map.getOrDefault(total -x, 0);
        }

        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */