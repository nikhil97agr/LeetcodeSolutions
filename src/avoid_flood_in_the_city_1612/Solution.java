package avoid_flood_in_the_city_1612;

import java.util.*;
class Solution {
    public int[] avoidFlood(int[] rains) {
        LinkedList<Integer> zeroes = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = rains.length;
        int res[] = new int[n];
        Arrays.fill(res, 1);

        for(int i=0;i<n;i++){
            if(rains[i]==0){
                zeroes.add(i);
                continue;
            }else{
                res[i] = -1;
                if(map.containsKey(rains[i])){
                    int idx = findDryDay(map.get(rains[i]), i, zeroes);
                    if(idx==-1){
                        return new int[]{};
                    }
                    res[idx] = rains[i];
                }
                map.put(rains[i], i);
            }
        }
        return res;
    }

    private int findDryDay(int start, int end, LinkedList<Integer> zeroes){

        Iterator<Integer> it = zeroes.iterator();
        while(it.hasNext()){
            int ind = it.next();
            if(ind>start && ind<end){
                it.remove();
                return ind;
            }
        }

        return -1;
    }
}