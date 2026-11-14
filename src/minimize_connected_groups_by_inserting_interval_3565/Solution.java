package minimize_connected_groups_by_inserting_interval_3565;

import java.util.*;
class Solution {
    public int minConnectedGroups(int[][] intervals, int k) {
        Arrays.sort(intervals, (i1,i2) ->{
            return i1[0] - i2[0];
        });
        List<int[]> list = new ArrayList<>();
        int s = -1;
        int e = -1;
        for(int i[] : intervals){
            if(s == -1){
                s = i[0];
                e = i[1];
                continue;
            }
            if(i[0] > e){
                list.add(new int[]{s,e});
                s = i[0];
                e = i[1];
            }else{
                e = Math.max(e, i[1]);
            }
        }

        list.add(new int[]{s,e});
        int ans = list.size();
        for(int ind = 0;ind < list.size();ind++){
            int i[] = list.get(ind);
            int i1 = search(list, i[1] + k );
            ans = Math.min(ans, list.size() - (i1 - ind));
        }
        return ans;

    }

    private int search(List<int[]> list, int val){
        int ind = list.size() - 1;
        int start = 0;
        int end = ind;

        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid)[0] > val){
                end = mid - 1;
            }else{
                start = mid + 1;
                ind = mid;
            }
        }

        return ind;
    }
}