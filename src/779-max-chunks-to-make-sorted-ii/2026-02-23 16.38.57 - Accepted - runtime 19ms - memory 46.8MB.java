import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int x : arr){
            map.merge(x, 1,Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for(int x : arr){
            map.merge(x, -1, Integer::sum);
            if(map.get(x) ==0) map.remove(x);
            int ind = Collections.binarySearch(list, x);
            if(ind < 0){
                ind = -ind -1;
            }
            
            if(list.isEmpty()){
                ans++;
                list.add(x);
                continue;
            }
            
            if(x >= list.get(list.size()-1) && (map.isEmpty() || map.firstKey() >= list.get(list.size()-1))){
                ans++;
                list.clear();
                list.add(x);
            }else{
                list.add(ind, x);
            }
        }
        return ans;
    }
}