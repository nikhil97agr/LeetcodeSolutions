package positions_of_large_groups_857;

import java.util.*;
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        int start =-0;
        int end = 0;
        char curr = s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == curr){
                end = i;
            }else{
                if(end - start + 1 >= 3){
                    list.add(Arrays.asList(start, end));
                }

                start = end = i;
                curr = s.charAt(i);
            }
        }

        if(end - start + 1 >=3){
            list.add(Arrays.asList(start, end));
        }
        return list;
    }
}