package plates_between_candles_2165;

import java.util.*;
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        TreeSet<Integer> set = new TreeSet<>();
        int pre[] = new int[n+1];

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c== '*'){
                pre[i+1] = pre[i] + 1;
            }else{
                set.add(i);
                pre[i+1] = pre[i];

            }
        }
        int q = queries.length;
        int ans[] = new int[q];

        for(int i=0;i<q;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(set.ceiling(l) == null || set.floor(r) == null){
                continue;
            }

            l = set.ceiling(l);
            r = set.floor(r);
            if(l > r){
                continue;
            }
            ans[i] = pre[r] - pre[l];
        }

        return ans;
    }
}