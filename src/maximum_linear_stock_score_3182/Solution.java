package maximum_linear_stock_score_3182;

import java.util.*;
class Solution {
    public long maxScore(int[] prices) {
        long ans = 0;
        Map<Long, List<Long>> map = new HashMap<>();
        for(int i=0;i<prices.length;i++){
            long diff = prices[i] - (i+1);
            map.computeIfAbsent(diff, x -> new ArrayList<>()).add(1l*prices[i]);
        }

        for(List<Long> list : map.values()){
            ans= Math.max(ans, list.stream().reduce(0l, Long::sum));
        }

        return ans;
    }
}