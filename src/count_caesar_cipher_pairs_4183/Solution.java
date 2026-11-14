package count_caesar_cipher_pairs_4183;

import java.util.*;
class Solution {
    public long countPairs(String[] words) {
        long ans = 0;
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();
        String normal[] = new String[n];
        for(int i=0;i<n;i++){
            String s = normalize(words[i]);
            map.merge(s, 1, Integer :: sum);
            normal[i] = s;
        }
        for(int i=0;i<n;i++){
            String s= normal[i];
            map.merge(s, -1, Integer::sum);
            ans += map.get(s);
        }
        return ans;
    }

    private String normalize(String s){
        char ch[] = s.toCharArray();
        int diff = (('z' - ch[0]) + 1)%26;

        StringBuilder sb = new StringBuilder();

        for(char c : ch){
            int ind = ( c - 'a');
            int next = (ind + diff)%26;
            sb.append((char)('a'+ next));
        }

        return sb.toString();
    }
}