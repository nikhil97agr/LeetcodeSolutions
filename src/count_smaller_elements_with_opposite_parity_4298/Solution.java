package count_smaller_elements_with_opposite_parity_4298;

import java.util.*;
class Solution {
    public int[] countSmallerOppositeParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        int n = nums.length;
        int ans[] = new int[n];

        for(int i=n-1;i>=0;i--){
            int val = nums[i];
            if(val%2==0){
                ans[i] = search(odd, val);
                insert(even, val);
            }else{
                ans[i] = search(even, val);
                insert(odd, val);
            }
        }


        return ans;
    }

    private void insert(List<Integer>list, int val){
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

    private int search(List<Integer> list, int val){
        int cnt = 0;
        int start =0;
        int end = list.size() - 1;
        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid) < val){
                cnt = mid + 1;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return cnt;
    }
}