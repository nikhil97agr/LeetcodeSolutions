package weighted_word_mapping_4216;

import java.util.*;
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        char res[] = new char[n];
        Map<Integer, Character> map = new HashMap<>();
        int i=0;
        for(char c = 'z';c>='a';c--, i++){
            map.put(i, c);
        }
        for( i=0;i<n;i++){
            int weight = calc(weights, words[i]);
            int mod = weight%26;
            res[i] = map.get(mod);
        }

        return new String(res);
    }

    private int calc(int weights[], String s){
        int ans = 0;
        for(char c : s.toCharArray()){
            int ind = c - 'a';
            ans += weights[ind];
        }
        return ans;
    }
}