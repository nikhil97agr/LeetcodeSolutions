package reducing_dishes_1503;

import java.util.*;
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int sum = 0;
        int ans = 0;
        int total = 0;
        for(int i=n-1;i>=0;i--){
            sum += satisfaction[i];
            total += sum;
            ans = Math.max(total, ans);
        }
        return ans;
    }
}