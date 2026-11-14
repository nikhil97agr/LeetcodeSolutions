package remove_sub_folders_from_the_filesystem_1350;

import java.util.*;
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (f1, f2) -> f1.length() - f2.length());

        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(String s : folder){
            String str[] = s.split("/");
            StringBuilder sb = new StringBuilder();
            boolean possible = true;
            for(String st : str){
                sb.append(":").append(st);
                if(set.contains(sb.toString())){
                    possible = false;

                    break;
                }
            
            }

            if(possible){
                result.add(s);
                set.add(sb.toString());
            }
            
        }
        return result;
    }
}