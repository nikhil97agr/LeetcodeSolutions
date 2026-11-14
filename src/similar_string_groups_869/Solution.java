package similar_string_groups_869;

import java.util.*;
class Solution {
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<String, Integer> map = new HashMap<>();
        String parent[] = new String[n];

        for(int i=0;i<n;i++){
            map.put(strs[i], i);
            parent[i] = strs[i];
        }
        strs = (new ArrayList<>(map.keySet())).toArray(new String[0]);
        n = strs.length;
        parent = new String[n];
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(strs[i],i);
            parent[i] = strs[i];
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cnt = charCount(strs[i], strs[j]);
                if(cnt ==0 || cnt == 2){
                    String p1 = findParent(i, parent, strs, map);
                    String p2 = findParent(j, parent, strs, map);
                    if(!p1.equals(p2)){
                        parent[map.get(p1)] = p2;
                    }
                }
            }
        }
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(findParent(i, parent, strs, map));
        }

        return set.size();

    }

    private String findParent(int i, String parent[], String strs[], Map<String, Integer>map){
        if(parent[i].equals(strs[i])){
            return parent[i];
        }

        return parent[i] = findParent(map.get(parent[i]), parent, strs, map);
    }

    private int charCount(String s1, String s2){
        int cnt = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }


}