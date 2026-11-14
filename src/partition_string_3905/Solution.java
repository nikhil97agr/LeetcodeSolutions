package partition_string_3905;

import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> partitionString(String s) {
        Set<Integer> set = new HashSet<>();

        List<String> res = new ArrayList<>();

        StringBuilder sb =new StringBuilder();

        for(char c : s.toCharArray()){
            sb.append(c);
            
            Integer hash  =sb.toString().hashCode();

            if (!set.contains(hash)) {
                res.add(sb.toString());
                set.add(hash);
                sb = new StringBuilder();
            }
        }
        
        return res;
    }
}