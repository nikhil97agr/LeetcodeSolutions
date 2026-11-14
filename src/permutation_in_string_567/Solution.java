package permutation_in_string_567;

import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(char c : s1.toCharArray()){
            freq1[c-'a']++;   
        }     
        for(int i=0;i<s1.length();i++){
            freq2[s2.charAt(i)-'a']++;   
        }    

        int i=0;
        int j=s1.length();

        while(j<s2.length()){
            if(Arrays.equals(freq1, freq2)){
                return true;
            }
            freq2[s2.charAt(i)-'a']--;
            freq2[s2.charAt(j)-'a']++;
            i++;
            j++;

        }
        if(Arrays.equals(freq1, freq2)){
            return true;
        }
        return false;
    }
}