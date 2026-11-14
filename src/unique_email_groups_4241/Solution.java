package unique_email_groups_4241;

import java.util.*;
class Solution {
    public int uniqueEmailGroups(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String s : emails){
            String split[] = s.split("@");
            String local = split[0];
            int ind = local.indexOf("+");
            if(ind != -1){
                local = local.substring(0, ind);
            }
            local = local.replaceAll("[.]", "").toLowerCase();
            
            split[1] = split[1].toLowerCase();
            set.add(local+"@"+split[1]);
        }

        return set.size();
    }
}