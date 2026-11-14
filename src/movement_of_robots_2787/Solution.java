package movement_of_robots_2787;

import java.util.*;
class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        long mod = (long)1e9 + 7;
        long ans = 0;
        int n = nums.length;
        long pos[] = new long[n];

        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'R'){
                pos[i] = 1l*nums[i] + d;
            }else{
                pos[i] = 1l * nums[i] - d;
            }
        }

        Arrays.sort(pos);
        long pre = 0;

        for(int i=0;i<n;i++){
            long total = ans + pos[i]*i - pre;
            ans = total%mod;
            pre = pre + pos[i];
            pre%=mod;
        }
        return (int)ans;
    }

}