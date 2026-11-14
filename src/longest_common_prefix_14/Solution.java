package longest_common_prefix_14;

import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        for(String s : strs){
            min = Math.min(min, s.length());
        }
        
        int n = strs.length;
        if(n==1){
            return strs[0];
        }
        
        char result[] = new char[min];
        Arrays.fill(result, ' ');
        for(int i=0;i<min;i++){
            char  c = strs[0].charAt(i);
            boolean temp = false;
            for(String s : strs){
                if(s.charAt(i)!=c){
                    temp = true;
                    break;
                }
            }
            if(temp){
                return String.valueOf(result).trim();
            }else{
                result[i] = c;
            }
        }
        return String.valueOf(result);
        
    }
}