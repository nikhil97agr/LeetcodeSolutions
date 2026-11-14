package split_a_string_into_the_max_number_of_unique_substrings_1715;

import java.util.*;
class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();

        return solve(set, s, 0, "");
    }


    private int solve(Set<String> set, String s, int ind, String curr){
        if(ind == s.length()){
            if(curr.isEmpty()) return 0;

            if(!set.contains(curr)) return 1;
            return -1000;
        }

        int ans = 0;
        if(!curr.isEmpty() && !set.contains(curr)){
            set.add(curr);
            ans = 1 + solve(set, s, ind+1, ""+s.charAt(ind));

            set.remove(curr);
        }

        curr+= s.charAt(ind);
        
        ans = Math.max(ans, solve(set, s, ind+1, curr));


        return ans;
    }
}