package brace_expansion_1076;

import java.util.*;
class Solution {
    public String[] expand(String s) {
        int i=0;
        Set<String> set= new HashSet<>();
        while(i < s.length()){
            char c = s.charAt(i);
            if(c== '{'){
                i++;
                Set<String> s1 = new HashSet<>();
                while(s.charAt(i) != '}'){
                    char ch = s.charAt(i);
                    if(ch==','){
                        i++;
                        continue;
                    }

                    s1.add(""+ch);
                    i++;
                }
                i++;
                set = merge(set, s1);

            }else{
                Set<String> st =Set.of(""+c);
                set = merge(set, st);
                i++;
            }
        }

        return set.stream().sorted().toArray(String[]::new);
    }

    private Set<String> merge(Set<String> s1, Set<String>s2){
        if(s1.isEmpty()){
            s1.addAll(s2);
            return s1;
        }

        Set<String> set = new HashSet<>();
        for(String s : s1){
            for(String st : s2){
                set.add(s + st);
            }
        }
        return set;
    }
}