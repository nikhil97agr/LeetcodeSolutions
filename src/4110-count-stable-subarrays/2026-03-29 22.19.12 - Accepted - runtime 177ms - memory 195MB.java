import java.util.Map;
import java.util.TreeMap;

class Solution {

    public long[] countStableSubarrays(int[] nums, int[][] queries) {

        var n = nums.length;
        var q = queries.length;
        var ans = new long[q];
        var pre = new long[n];
        var last = new int[n];
        var map = new TreeMap<Integer, Integer>();
        for (int start = 0, end = 0; end < n; end++) {
            add(nums[end], map);
            while(map.lastKey() > nums[end]){
                remove(nums[start], map);
                start++;
                
            }
            
            long sub = end - start + 1;
            pre[end] = sub + (end - 1 >=0 ? pre[end-1] : 0);
            last[end] = start;
        }
        
        for(int i=0;i<q;i++){
            int l= queries[i][0];
            var r = queries[i][1];
            int ind = binarySearch(last, l, r);
            
            if(ind == -1){
                ans[i] = pre[r] - (l-1 >=0 ? pre[l-1] : 0);
            }else{
                ans[i] = pre[r] - pre[ind];
                int len = ind - l + 1;
                ans[i] += (1l * len * (len + 1))/2;
            }
        }

        return ans;
    }
    
    private int binarySearch(int last[], int l, int r){
        int ind = -1;
        int s = l;
        while(l <= r){
            int mid = (l + r)/2;
            
            if(last[mid] < s){
                ind= mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        
        return ind;
    }

    private void add(int a, Map<Integer, Integer> map){
        map.merge(a, 1, Integer::sum);
    }

    private void remove(int a, Map<Integer, Integer> map)
    {
        map.merge(a, -1, Integer::sum);
        if(map.get(a) == 0) map.remove(a);
    }
}