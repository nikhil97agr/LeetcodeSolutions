package maximize_happiness_of_selected_children_3351;

import java.util.*;
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long diff = 0;
        long ans = 0;
        for(int i =n-1;i>=0 && k > 0 ; i--, k--){
            ans += Math.max(0, 1L*happiness[i] - diff);
            diff++;
        }
        return ans;
    }
}