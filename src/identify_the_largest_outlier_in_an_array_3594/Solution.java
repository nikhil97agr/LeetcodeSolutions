package identify_the_largest_outlier_in_an_array_3594;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getLargestOutlier(new int[]{-402,907,-288,505}));
    }
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            sum += x;
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int ans = Integer.MIN_VALUE;
        for(int x : nums){
            int left = sum - x;
            if(left%2!=0) continue;
            int half = left/2;
            if(half == x){
                if(map.get(half)>1) ans = Math.max(ans, x);
            }else if(map.containsKey(half)){
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
}