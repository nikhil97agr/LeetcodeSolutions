package unique_number_of_occurrences_1319;

import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr) map.put(x, map.getOrDefault(x, 0)+1);

        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }
}