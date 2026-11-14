package maximize_score_of_numbers_in_ranges_3485;

import java.util.*;
class Solution {
    public int maxPossibleScore(int[] start, int d) {
        int ans= 0;
        Arrays.sort(start);
        
        int l = 0;
        int r = start[start.length-1] + d;
        while(l <= r){
            int mid = l + (r-l)/2;
            
            boolean possible = true;
            long curr= start[0];
            
            for(int i=1;i<start.length;i++){
                curr += mid;
                
                if(curr < 1L*start[i]){
                    curr =1l*start[i];
                    continue;
                }
                
                if(1L*start[i] +1l*d < curr){
                    possible = false;
                    break;
                }
            }
            
            if(!possible){
                r = mid-1;
            }else{
                l = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
}