package calculate_score_after_performing_instructions_3732;

import java.util.*;
class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long ans = 0;
        Set<Integer> vis =new HashSet<>();

        int n = instructions.length;
        int i=0;
        while(i >=0 && i < n && !vis.contains(i)){
            String s = instructions[i];
            int val = values[i];
            vis.add(i);
            if(s.equals("add")){
                ans += val;
                i++;
            }else{
                i+=val;
            }
        }
        return ans;
    }
}