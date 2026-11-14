package maximum_fruits_harvested_after_at_most_k_steps_2229;

import java.util.*;
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxStartPos = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int f[] : fruits){
            maxStartPos = Math.max(maxStartPos,f[0]);

            map.put(f[0], f[1]);
        }
        maxStartPos = Math.max(maxStartPos, startPos);
        int left[] = new int[maxStartPos+1];
        int right[] = new int[maxStartPos+1];
        left[startPos] = map.getOrDefault(startPos, 0);
        right[startPos] = map.getOrDefault(startPos,0);
        
        for(int i=startPos+1;i<=maxStartPos;i++){
            right[i] = right[i-1] + map.getOrDefault(i, 0);
        }
        for(int i=startPos-1;i>=0;i--){
            left[i] = left[i+1] + map.getOrDefault(i, 0);
        }

        int ans = map.getOrDefault(startPos, 0);
        int temp = k;
        int def = map.getOrDefault(startPos, 0);
        int i = startPos+1;

        while(i<=maxStartPos && temp>0){
            temp--;
            int leftMoves =temp - ( i-startPos);
            int total = right[i] + ((leftMoves<=0) ? 0 :( left[Math.max(startPos-leftMoves, 0)] - def));
            ans = Math.max(ans, total);
            i++;
        }
        temp = k;
        i = startPos-1;
        while(i>=0 && temp > 0){
            temp--;
            int leftMoves = temp - (startPos - i);
            int total = left[i] + ((leftMoves<=0) ? 0 : (right[Math.min(startPos + leftMoves, maxStartPos)] - def));
            ans = Math.max(ans, total);
            i--;
        }

        return ans;

        

    }
}