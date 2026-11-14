import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public long countRatioSubarrays(int[] nums, int a, int b) {
        long ans = 0;
        long prev = 0;
        List<Long> temp = new ArrayList<>();
        List<Long> list = new ArrayList<>();
        
        long x= 0;
        long y = 0;
        temp.add(0l);
        
        
        for(int num : nums){
            if(num%2==0){
                  x++;      
            }else{
                y++;
            }
            long val = x * b - y * a;
            if(y == prev){
                temp.add(val);
            }else{
                update(temp, list);
                prev = y;
                temp.clear();
                temp.add(val);
            }
            
            int cnt = search(list, val);
            
            ans += cnt;
        }
        
        return ans;
    }
    
    private void update(List<Long> temp, List<Long> list){
        for(var x : temp){
            var ind = Collections.binarySearch(list, x);
            if(ind < 0){
                ind = -ind -1 ;
            }
            
            if(ind == list.size()){
                list.add(x);
            }else{
                list.add(ind, x);
            }
        }
    }
    
    private int search(List<Long> list, long val){
        int n = list.size();
        int start = 0;
        int end = n - 1;
        int ans = 0;
        while(start <= end){
            int mid = (start + end)/2;
            
            if(list.get(mid) >= val){
                ans = n - mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return ans;
    }
}