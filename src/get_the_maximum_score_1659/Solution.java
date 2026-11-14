package get_the_maximum_score_1659;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long ans = 0;
        int p1 = 0;
        int p2 = 0;
        int n = nums1.length;
        int m = nums2.length;

        long pre1[] = new long[n+1];
        long pre2[] = new long[m+1];

        for(int i=1;i<=n;i++){
            pre1[i] =pre1[i-1] + nums1[i-1];
        }

        for(int i=1;i<=m;i++){
            pre2[i] = pre2[i-1] +nums2[i-1];
        }

        Map<Integer, Integer> m1 = generate(nums1);
        Map<Integer, Integer> m2 = generate(nums2);

        LinkedList<Integer> list = new LinkedList<>();

        for(int x : nums1){
            if(m2.containsKey(x)){
                list.add(x);
            }
        }

        for(int x : list){
            int i = m1.get(x);
            int j = m2.get(x);

            ans = ans + Math.max(pre1[i] -pre1[p1], pre2[j] -pre2[p2]);
            ans = (ans+ x);
            p1 =i +1;
            p2 = j+1;

        }

        ans = ans + Math.max(pre1[n] -pre1[p1], pre2[m] -pre2[p2]);

        long mod = (long)1e9 + 7;
        return (int)(ans%mod);

    }

    private Map<Integer, Integer> generate(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }

        return map;
    }

}