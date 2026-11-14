package odd_even_jump_1017;

import java.util.*;
class Solution {
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n =arr.length;
        boolean dp[][] = new boolean[n][2];

        dp[n-1] = new boolean[]{true, true};
        if(n==1) return 1;

        if(arr[n-2]<arr[n-1]){
            dp[n-2][1] = true;
        }else if(arr[n-2] >  arr[n-1]){
            dp[n-2][0] = true;
        }else{
            dp[n-2] = new boolean[]{true, true};
        }
        map.put(arr[n-1], n-1);
        map.put(arr[n-2], n-2);

        for(int i=n-3;i>=0;i--){
            Map.Entry<Integer, Integer> max = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> min = map.floorEntry(arr[i]);

            if(max==null){
                dp[i][1] = false;
            }else{
                int ind = max.getValue();
                dp[i][1] = dp[ind][0];
            }
            if(min==null){
                dp[i][0] = false;
            }else{
                int ind = min.getValue();
                dp[i][0] = dp[ind][1];
            }

            map.put(arr[i], i);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            if(dp[i][1]){
                ans++;
            }
        }
        return ans;
    }
}