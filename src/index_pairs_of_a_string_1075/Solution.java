package index_pairs_of_a_string_1075;

import java.util.*;
import java.util.stream.*;
class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        System.out.println(set);
        for(int i=0;i<text.length();i++){
            for(int j=i;j<text.length();j++){
                String sub = text.substring(i, j+1);
                if(set.contains(sub)){
                    list.add(new int[]{i,j});
                }
            }
        }
        int ans[][] = new int[list.size()][2];

        for(int i=0;i<list.size();i++) ans[i] = list.get(i);
        return ans;
    }
}