package minimum_adjacent_swaps_to_alternate_parity_3904;

import java.util.*;
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) even.add(i);
            else odd.add(i);
        }
        int e = even.size();
        int o = odd.size();

        int ans = Integer.MAX_VALUE;

        if(Math.abs(e-o) > 1 ) return -1;

        if(e >= o){
            int cnt = 0;

            for(int i=0;i<e;i++){
                cnt += Math.abs(even.get(i) - 2*i);
            }



            ans= Math.min(ans, cnt);
        }

        if(o >= e){
            int cnt = 0;
            for(int i=0;i<o;i++){
                cnt += Math.abs(odd.get(i) - 2*i);
            }


            ans = Math.min(ans, cnt);
        }

        return ans;

        
    }
}