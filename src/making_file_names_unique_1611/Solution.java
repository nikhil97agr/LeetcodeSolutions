package making_file_names_unique_1611;

import java.util.*;
class Solution {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        Map<String, Integer> map = new HashMap<>();
        String result[] = new String[n];
        for(int i=0;i<n;i++){
            String curr = names[i];
            if(!map.containsKey(curr)){
                result[i] = curr;
                map.put(curr, 1);
            }else{
                build(map, curr);
                int cnt = map.get(curr) - 1;
                result[i] = curr+"("+cnt+")";
            }
        }

        return result;
    }

    private void build(Map<String, Integer> map, String curr){
        int cnt = map.get(curr);
        String next = curr +"("+cnt+")";

        if(map.containsKey(next)){
            map.put(curr, cnt + 1);
            build(map, curr);
        }else{
            map.put(next, 1);
            map.put(curr, cnt + 1);
        }
    }
}