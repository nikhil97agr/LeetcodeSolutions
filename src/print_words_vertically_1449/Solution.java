package print_words_vertically_1449;

import java.util.*;
import java.util.stream.*;
class Solution {
    public List<String> printVertically(String s) {
        String words[] = s.split(" ");
        int maxLen = Arrays.stream(words).map(String::length).max(Integer::compareTo).get();
        List<StringBuilder> result =new ArrayList<>();
        for(int i=0;i<maxLen;i++){
            result.add(new StringBuilder());
        }
        for(String str : words){
            int i =0;
            for(i=0;i<str.length();i++){
                result.get(i).append(str.charAt(i));
            }
            while(i<maxLen){
                result.get(i).append(' ');
                i++;
            }
        }
        return result.stream().map(sb ->{
            String str = sb.toString();
            int spaces = 0;
            int n = str.length();
            int i = n-1;
            while(i>=0 && str.charAt(i) == ' ') i--;
            return str.substring(0, i+1);
        }).collect(Collectors.toList());
    }
}