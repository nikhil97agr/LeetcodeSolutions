package check_if_string_is_transformable_with_substring_sort_operations_1707;

import java.util.*;
import java.util.TreeSet;

class Solution {
    public boolean isTransformable(String s, String t) {
        int n = s.length();
        int m = t.length();
        TreeSet<Integer> set[] = new TreeSet[10];
        for(int i=0;i<10;i++) set[i] = new TreeSet<>();
        for(int i=0;i<n;i++){
            int dig = s.charAt(i) - '0';
            set[dig].add(i);
        }

        for(int i=0;i<m;i++){
            int dig = t.charAt(i) - '0';
            if(set[dig].isEmpty()) return false;
            int ind = set[dig].pollFirst();
            for(int j=dig -1;j>=0;j--){
                if(!set[j].isEmpty() && set[j].first() < ind) return false;
            }
        }
        
        return true;
    }
}