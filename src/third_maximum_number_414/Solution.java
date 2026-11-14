package third_maximum_number_414;

import java.util.*;
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int x : nums) set.add(x);
        if(set.size() < 3) return set.getFirst();
        set.removeFirst();
        set.removeFirst();
        return set.getFirst();
    }
}