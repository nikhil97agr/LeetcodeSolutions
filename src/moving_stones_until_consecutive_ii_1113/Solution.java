package moving_stones_until_consecutive_ii_1113;

import java.util.*;
class Solution {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        int max = Math.max(stones[n-1] - stones[1], stones[n-2] - stones[0]) - (n-2);
        int min = n;
        int start =0;
        for(int end = 0;end <n;end++){
            while(stones[end] - stones[start] >= n) start++;

            int len = end - start + 1;

            if(len == n-1 && stones[end] - stones[start] == n-2){
                min = Math.min(min, 2);
            }else{
                min = Math.min(min, n - len);
            }

        }

        return new int[]{min, max};
    }
}