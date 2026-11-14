package range_frequency_queries_1294;

import java.util.*;
class RangeFreqQuery {
    Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        int n = arr.length;
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i], x-> new ArrayList<>()).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        List<Integer> indexes = map.get(value);
        if(indexes==null) return 0;

        int start = -1;
        int end = -1;

        int  l = 0;
        int r = indexes.size()-1;

        while(l <= r){
            int mid = (l+r)>>1;
            if(indexes.get(mid) >= left){
                start = mid;
                r = mid-1;
            }else{
                l =mid+1;
            }
        }

        l = 0;
        r = indexes.size()-1;

        while(l<=r){
            int mid = (l+r)>>1;
            if(indexes.get(mid) <= right ){
                end = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        if(start == -1 || end == -1 || indexes.get(start) > right || indexes.get(end) < left) return 0;

        return (end - start + 1);
    }

}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */