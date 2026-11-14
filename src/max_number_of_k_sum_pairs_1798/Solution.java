package max_number_of_k_sum_pairs_1798;

import java.util.*;
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        int cnt = 0;
        for(int x : nums){
            if(map.containsKey(x)&&map.containsKey(k-x)){
                if(x*2==k){
                    int c = map.get(x);
                    if(c>=2){
                        cnt++;
                        if(c==2){
                            map.remove(x);
                        }else{
                            map.put(x, c-2);
                        }
                    }
                }else{
                    cnt++;
                    int c1 = map.get(x);
                    int c2 = map.get(k-x);
                    if(c1==1){
                        map.remove(x);
                    }else{
                        map.put(x, c1-1);
                    }

                    if(c2==1){
                        map.remove(k-x);
                    }else{
                        map.put(k-x, c2-1);
                    }

                }
            }
        }
        return cnt;
    }
}