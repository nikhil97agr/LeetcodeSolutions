package car_pooling_1184;

import java.util.*;
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int t[] : trips){
            map.merge(t[1], t[0], Integer::sum);
            map.merge(t[2], -t[0], Integer::sum);
        }

        int cnt = 0;
        for(int val : map.values()){
            cnt += val;
            if(cnt > capacity) return false;
        }

        return true;
    }
}