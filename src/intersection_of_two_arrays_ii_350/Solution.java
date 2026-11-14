package intersection_of_two_arrays_ii_350;

import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int max = Math.max(Arrays.stream(nums1).max().getAsInt(),
                Arrays.stream(nums2).max().getAsInt());
        
        int cnt1[] = new int[max+1];
        int cnt2[] = new int[max+1];
        cnt(nums1, cnt1);
        cnt(nums2, cnt2);

        int resSize = 0;
        for(int i=0;i<=max;i++){
            resSize += Math.min(cnt1[i], cnt2[i]);
        }

        int res[] = new int[resSize];

        int i=0;
        for(int j=0;j<=max;j++){
            int min = Math.min(cnt1[j], cnt2[j]);
            while(min-- > 0){
                res[i++] = j;
            }
        }
        return res;
    }

    public void cnt(int arr[], int cnt[]){
        for(int x : arr) cnt[x]++;
    }
}