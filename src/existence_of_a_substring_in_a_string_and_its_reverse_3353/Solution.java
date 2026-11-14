package existence_of_a_substring_in_a_string_and_its_reverse_3353;

import java.util.*;
class Solution {
    public boolean isSubstringPresent(String s) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length()-1;i++){
            set.add(s.substring(i,i+2));
        }
        
        for(int j=s.length()-1;j>0;j--){
            String temp = ""+s.charAt(j)+s.charAt(j-1);
            if(set.contains(temp)) return true;
        }
        return false;
    }
}