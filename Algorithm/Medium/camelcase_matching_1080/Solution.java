package camelcase_matching_1080;

import java.util.*;
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for(String s : queries){
            int j = 0;
            boolean ans = true;
            int i=0;
            while(i<s.length() && j<pattern.length()){
                if(s.charAt(i) == pattern.charAt(j)){
                    j++;
                }else if(Character.isUpperCase(s.charAt(i))){
                    ans = false;
                    break;
                }
                i++;

            }
            if(ans){

                if(j==pattern.length()){
                    while(i<s.length() && !Character.isUpperCase(s.charAt(i))){
                        i++;
                    }

                    if(i!=s.length()) result.add(false);
                    else result.add(true);
                }else{
                    result.add(false);
                }

            }else{
                result.add(false);
            }
        }
        return result;
    }
}