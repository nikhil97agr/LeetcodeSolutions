package longest_consecutive_sequence_128;

import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap();
        for(int x : nums){
            map.put(x, true);
        }
        for(int x : nums){
            if(map.containsKey(x-1)) map.put(x, false);
        }
        int length = 0;
        for(int x : nums){
            int temp = 1;
            if(map.get(x)){
                while(map.containsKey(++x))temp++;
                length = Math.max(length, temp);
            }
        }
        return length;
    }
}