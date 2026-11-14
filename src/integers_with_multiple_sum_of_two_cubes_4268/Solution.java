package integers_with_multiple_sum_of_two_cubes_4268;

import java.util.*;


class Solution {
    public List<Integer> findGoodIntegers(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int start = 1;start<=Math.min(n,1000);start++){
            long a = 1l *start*start*start;
            for(int end = start + 1;end<=Math.min(n, 1000);end++){
                long b = 1l *end*end*end;
                if(a+b <= n){
                    map.merge((int)(a+b), 1, Integer::sum);
                }else{
                    break;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(var entry : map.entrySet()){
            if(entry.getValue() > 1){
                result.add(entry.getKey());
            }
        }
        
        Collections.sort(result);
        return result;
    }
}