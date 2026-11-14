package toggle_light_bulbs_4212;

import java.util.*;
class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean flag[] = new boolean[101];
        for(int x : bulbs){
            flag[x] = !flag[x];
        }
        List<Integer> result =new ArrayList();
        for(int i=1;i<=100;i++){
            if(flag[i]) result.add(i);
        }

        return result;
    }
}