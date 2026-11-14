package longest_word_in_dictionary_through_deleting_524;

import java.util.*;
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
    //    Collections.sort(dictionary, (a,b)->{
    //        if(a.length()==b.length()){
    //            return a.compareTo(b);
    //        }
    //        return b.length()-a.length();
    //    });
    String result = "";
       for(String x : dictionary){
           if(match(s, x)){
               if(x.length()>result.length()){
                   result = x;
               }else if(x.length()==result.length() && x.compareTo(result)<0){
                   result = x;
               }
               
           }
       }

       return result;
    }

    private boolean match(String s, String x){
        int m = s.length();
        int n = x.length();
        int i=0;
        int j=0;
        while(i<m){
            if(s.charAt(i)==x.charAt(j)){
                j++;
            }
            if(j==n){
                return true;
            }
            i++;
        }

        return false;
    }
}