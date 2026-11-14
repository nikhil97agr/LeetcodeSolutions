package number_of_times_binary_string_is_prefix_aligned_1491;

import java.util.*;
class Solution {
    public int numTimesAllBlue(int[] flips) {
        TreeSet<Integer> set = new TreeSet<>();
        int ans = 0;
        for(int x : flips){
            set.add(x);
            int first = set.first();
            int last = set.last();
            if(first == 1 && last == set.size()) ans++;
        }

        return ans;
    }
}