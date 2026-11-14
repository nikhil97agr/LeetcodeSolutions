package minimum_operations_to_make_the_array_k_increasing_2234;

import java.util.*;
class Solution {
    public int kIncreasing(int[] arr, int k) {
        Set<Integer> vis = new HashSet<>();
        int ans = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(vis.contains(i)) continue;
            List<Integer> list = new ArrayList<>();
            int cnt = 0;

            int j=i;
            while(j < n){
                int val = arr[j];
                vis.add(j);
                cnt++;
                int ind = search(list, val);
                if(ind == -1){
                    list.add(val);
                }else{
                    list.set(ind, val);
                }

                j+=k;
            }

            ans +=  cnt - list.size();
        }

        return ans;
    }

    private int search(List<Integer> list,int  val){
        int ind = -1;
        int start =0;
        int end = list.size()-1;
        while(start <= end){
            int mid = (start+end)/2;

            if(list.get(mid) <= val){
                start = mid + 1;
            }else{
                end= mid - 1;
                ind = mid;
            }
        }

        return ind;
    }
}