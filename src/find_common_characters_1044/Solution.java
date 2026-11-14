package find_common_characters_1044;

import java.util.*;
class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int vis[][] = new int[n][26];
        for(int i=0;i<n;i++){
            for(char c : words[i].toCharArray()){
                vis[i][c-'a']++;
            }
        }

        List<String> res = new ArrayList<>();

        for(char c = 'a';c<='z';c++){
            int min = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                min = Math.min(min, vis[i][c-'a']);
            }

            for(int i=0;i<min;i++){
                res.add(""+c);
            }
        }
        return res;


    }
}