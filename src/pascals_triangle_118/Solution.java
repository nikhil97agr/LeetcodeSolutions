package pascals_triangle_118;

import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if(numRows==1) return result;
        
        result.add(Arrays.asList(1,1));
        if(numRows==2) return result;
        int curr = 2;
        while(curr < numRows){
            List<Integer> prev = result.get(curr-1);
            Integer row[] = new Integer[curr+1];
            row[0] = 1;
            row[curr] =1;
            for(int i=0;i<prev.size()-1;i++){
                row[i+1] = prev.get(i) + prev.get(i+1);
            }
            result.add(Arrays.asList(row));
            curr++;
        }
        
        return result;
    }
}