class Solution {
    public int constrainedSubsetSum(int nums[], int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        if (max <= 0)
            return max;

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        Queue<Integer> que = new LinkedList<>();
        max = nums[0];
        map.put(nums[0], 1);
        que.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (que.size() + 1 > k + 1) {
                int ele = que.poll();
                if (map.get(ele) == 1)
                    map.remove(ele);
                else
                    map.put(ele, map.get(ele) - 1);
            }
            int next = Math.max(nums[i] + map.firstEntry().getKey(), nums[i]);
            max = Math.max(next, max);
            que.add(next);
            map.put(next, map.getOrDefault(next, 0) + 1);
        }
        return max;
    }
}