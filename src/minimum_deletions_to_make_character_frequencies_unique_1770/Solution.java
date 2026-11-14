package minimum_deletions_to_make_character_frequencies_unique_1770;

import java.util.*;
class Solution {
    public int minDeletions(String s) {
        int count = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt[] = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int x : cnt) {
            if (x != 0) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int prevKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = prevKey+1; i < entry.getKey(); i++) {
                pq.add(i);
            }
            prevKey = entry.getKey();
            if (entry.getValue() == 1) {
                continue;
            }
            for (int i = 1; i < entry.getValue(); i++) {
                if (pq.isEmpty()) {
                    count += entry.getKey();
                } else {
                    count += entry.getKey() - pq.poll();
                }
            }
        }

        return count;
    }
}