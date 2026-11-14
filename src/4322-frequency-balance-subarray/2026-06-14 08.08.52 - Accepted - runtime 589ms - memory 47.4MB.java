import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {

    public int getLength(int[] nums) {

        int ans = 1;
        var n = nums.length;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            TreeMap<Integer, Integer> m2 = new TreeMap<>();
            for (int j = i; j < n; j++) {
                if (check(nums[j], map, m2)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private boolean check(int val, Map<Integer, Integer> map, TreeMap<Integer, Integer> m2) {

        int prev = map.getOrDefault(val, 0);

        remove(m2, prev);
        add(map, val);
        add(m2, prev + 1);
        if (map.size() == 1) {
            return true;
        }

        if (m2.size() != 2) {
            return false;
        }
        if (m2.firstKey() * 2 == m2.lastKey()) {
            return true;
        }
        return false;
    }

    private void remove(Map<Integer, Integer> map, int val) {

        if (!map.containsKey(val)) {
            return;
        }
        map.merge(val, -1, Integer::sum);
        if (map.get(val) == 0) {
            map.remove(val);
        }
    }

    private void add(Map<Integer, Integer> map, int val) {

        map.merge(val, 1, Integer::sum);
    }


}