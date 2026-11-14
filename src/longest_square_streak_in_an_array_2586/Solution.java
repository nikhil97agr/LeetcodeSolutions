package longest_square_streak_in_an_array_2586;

import java.util.*;
class Solution {
    public int longestSquareStreak(int[] nums) {
        int len = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int x : nums){
            set.add(x);
        }
        for(int x : nums){
            int count = 1;
            int num = x;
            while(num <=1000 && num!=1 && set.contains(num*num)){
                num = num*num;
                count++;
            }
            len = Math.max(len,count);
        }
        
        return len<2 ? -1 : len;
    }
}