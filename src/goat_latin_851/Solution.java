package goat_latin_851;

import java.util.*;
class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> set =new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        String str[] = sentence.split(" ");
        int n =str.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            String s = str[i];
            char c = s.charAt(0);
            int len = s.length();
            if(set.contains(c)){
                sb.append(s).append("ma").append("a".repeat(i+1)).append(" ");
            }else{
                sb.append(s.substring(1)).append(c).append("ma").append("a".repeat(i+1)).append(" ");
            }
        }
        return sb.toString().trim();
    }
}