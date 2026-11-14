package group_shifted_strings_249;

import java.util.*;
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<2;i++){
            for(char c = 'a';c<='z';c++){
                sb.append(c);
            }
        }
        String s = sb.toString();
        Map<Integer, List<String>> map = new HashMap<>();
        for(String st : strings){
            sb = new StringBuilder();
            for(int i=0;i<st.length()-1;i++){
                char a = st.charAt(i);
                char b = st.charAt(i+1);
                int i1 = s.indexOf(a);
                int i2 = s.indexOf(b);

                if(i2 < i1){
                    i2 = s.lastIndexOf(b);
                }

                sb.append((i2-i1));
                sb.append(":");
            }

            String s1 = sb.toString();
            map.computeIfAbsent(s1.hashCode(), x-> new ArrayList<>()).add(st);
        }

        return map.values().stream().toList();

    }
}