package count_unique_characters_of_all_substrings_of_a_given_string_855;

import java.util.*;

class Solution {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        int n = s.length();
        for(int i=0;i<n;i++){
            char c  = s.charAt(i);
            final int index = i;
            map.compute(c, (key, val)->{
                if(val == null){
                    val =new ArrayList<>();
                    val.add(-1);
                }
                
                val.add(index);
                return val;
            });
        }

        for(char c = 'A';c<='Z';c++){
            if(map.containsKey(c)){
                map.get(c).add(n);
            }
        }
        int ans = 0;
        for(List<Integer> list : map.values()){
            for(int i=1;i<list.size() - 1;i++){
                int left = list.get(i) - list.get(i-1);
                int right = list.get(i+1) - list.get(i);
                ans += left * right;
            }
        }

        return ans;
    }
}