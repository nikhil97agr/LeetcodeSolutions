package number_of_pairs_satisfying_inequality_2513;

import java.util.*;
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        List<Integer> list = new ArrayList<>();
        long ans = 0;
        int n = nums1.length;
        for(int i=n-1;i>=0;i--){
            int req = nums1[i] - nums2[i];
            int cnt = bs(list, req);
            ans += cnt;
            int val = nums1[i] - nums2[i] + diff;
            int ind = Collections.binarySearch(list, val);
            if(ind < 0){
                ind = -ind - 1;
            }

            if(ind == list.size()){
                list.add(val);
            }else{
                list.add(ind, val);
            }
        }

        return ans;
    }

    private int bs(List<Integer> list, int val){
        int ind = 0;
        int start =0;
        int end = list.size() - 1;
        int n= list.size();
        while(start <= end){
            int mid = (start + end) /2;

            if(val <= list.get(mid)){
                ind = n - mid;
                end= mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ind;
    }
}