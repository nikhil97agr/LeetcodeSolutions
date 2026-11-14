package intervals_between_identical_elements_2240;

import java.util.*;
class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long ans[] = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }

        for(List<Integer> list : map.values()){
            long pre[] = new long[list.size()];
            pre[0] = 0;
            long cnt = 1;
            for(int i=1;i<list.size();i++){
                pre[i] = pre[i-1] + cnt*(list.get(i) - list.get(i-1));
                cnt++;
            }
            long sum =0;
            cnt = 0;

            int size = list.size();
            for(int i=size-1;i>=0;i--){
                if(i==size-1){
                    ans[list.get(i)] = pre[i];
                }else{
                    sum += cnt*(list.get(i+1) - list.get(i));
                    ans[list.get(i)] = pre[i] + sum;
                }
                cnt++;
                
            }

        }

        return ans;
    }
}