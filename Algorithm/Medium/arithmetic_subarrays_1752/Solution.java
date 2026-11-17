package arithmetic_subarrays_1752;

import java.util.*;
import java.util.stream.*;
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();

        int m = l.length;
        for(int i=0;i<m;i++){
            final int minMax[] = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
            Set<Integer> set = IntStream.range(l[i], r[i]+1).boxed().map(a->{
                minMax[0] = Math.min(minMax[0], nums[a]);
                minMax[1] = Math.max(minMax[1], nums[a]);
                return nums[a];
            }).collect(Collectors.toSet());
            int diff = (minMax[1] - minMax[0])/(r[i] - l[i]);
            if(diff==0){
                if(set.size()==1){
                    res.add(true);
                    
                }else{
                    res.add(false);
                }
                continue;

            }
            int j = r[i] - l[i];
            boolean ans = true;
            while(j>0){
                int next = minMax[0]+j*diff;
                if(set.contains(next)){
                    j--;
                    continue;
                }
                ans = false;
                break;

            }
            res.add(ans);
        }
        return res;
    }
}