package minimum_rounds_to_complete_all_tasks_2362;

import java.util.*;
class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int x : tasks){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int count = 0;
        boolean result = true;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                result = false;
                break;
            }
            if(entry.getValue()%3==0){
                count += entry.getValue()/3;
                continue;
            }
            if(entry.getValue()%3==1){
                count += 2 + (entry.getValue()-4)/3;
                continue; 
            }
            
            
            count += 1+(entry.getValue()-2)/3;
        }

        if(!result){
            return -1;
        }
        return count;
    }
}