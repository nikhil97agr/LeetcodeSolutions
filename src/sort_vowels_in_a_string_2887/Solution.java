package sort_vowels_in_a_string_2887;

import java.util.*;
class Solution {
    public String sortVowels(String s) {
        TreeMap<Character, Integer> vowels = new TreeMap<>((a,b)->{
            int x = (int)a;
            int y = (int)b;

            return a-b;
        });
        char c [] =s.toCharArray();
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        List<Integer> indexes = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(set.contains(c[i])){
                vowels.put(c[i], vowels.getOrDefault(c[i], 0)+1);
                indexes.add(i);
            }
        }

        int i=0;
        for(char ch : vowels.keySet()){
            for(int j=0;j<vowels.get(ch);j++){
                c[indexes.get(i++)] = ch;
            }
        }

        return String.valueOf(c);


        
    }
}