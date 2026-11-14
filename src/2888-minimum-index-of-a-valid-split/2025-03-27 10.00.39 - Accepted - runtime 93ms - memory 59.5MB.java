class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int n = nums.size();
        int half = n / 2;
        int ele = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > half) {
                ele = entry.getKey();
                break;
            }
        }

        if (ele == -1)
            return -1;
        Map<Integer, Integer> end = new HashMap<>();
        Map<Integer, Integer> start = new HashMap<>();
        int i = 0;

        for (int j = 0; j < n; j++) {
            add(end, nums.get(j));
        }

        while (i < n - 1) {
            add(start, nums.get(i));
            remove(end, nums.get(i));

            int s1 = i + 1;
            int s2 = n - (i + 1);
            if (start.getOrDefault(ele, 0) > s1 / 2 && end.getOrDefault(ele, 0) > s2 / 2) {
                return i;
            }
            i++;
        }

        return -1;
    }

    private void add(Map<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private void remove(Map<Integer, Integer> map, int val) {
        if (map.get(val) == 1)
            map.remove(val);
        else
            map.put(val, map.get(val) - 1);
    }
}