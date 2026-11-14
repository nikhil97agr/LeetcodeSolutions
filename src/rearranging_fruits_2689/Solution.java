package rearranging_fruits_2689;

import java.util.*;
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int x : basket1){
            min = Math.min(min, x);
            m1.merge(x, 1, Integer::sum);
        }

        for(int y : basket2){
            m2.merge(y, 1, Integer::sum);
            min= Math.min(min, y);
        }

        long ans = 0;
        for(int x : basket1){
            if((m1.get(x) + m2.getOrDefault(x,0))%2==1) return -1;
        }

        for(int y : basket2){
            if((m2.get(y) + m1.getOrDefault(y, 0))%2==1) return -1;
        }

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int key : m1.keySet()){
             int cnt = m1.get(key) + m2.getOrDefault(key, 0);
            int extra = cnt/2 - m2.getOrDefault(key, 0);
            while(extra-- > 0){
                l1.add(key);
            }
        }

        for(int key : m2.keySet()){
            int cnt = m2.get(key) + m1.getOrDefault(key, 0);
            int extra = cnt/2 - m1.getOrDefault(key, 0);
            while(extra-- > 0){
                l2.add(key);
            }
            
        }

        Collections.sort(l1);
        Collections.sort(l2);

        int i1 = 0;
        int j1 = l1.size()-1;
        int i2 = 0;
        int j2= l2.size()-1;
        int swap = l1.size();
        while(swap > 0){
            if(l1.get(i1) < l2.get(i2)){
                int val = l1.get(i1);
                ans += Math.min(min * 2, val);
                i1++;
                j2--;
            }else{
                int val = l2.get(i2);
                ans += Math.min(min*2, val);
                i2++;
                j1--;
            }
            swap--;
        }

        return ans;




    }
}