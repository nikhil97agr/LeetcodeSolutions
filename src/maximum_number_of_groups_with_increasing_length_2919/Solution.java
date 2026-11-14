package maximum_number_of_groups_with_increasing_length_2919;

import java.util.*;
class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        int cnt = 0;
        long total = 0;
        for(int x : usageLimits){
            total += x;

            if(total >= (1l * (cnt+1) * (cnt+2))/2){
                cnt++;
            }
        }

        return cnt;
    }
}