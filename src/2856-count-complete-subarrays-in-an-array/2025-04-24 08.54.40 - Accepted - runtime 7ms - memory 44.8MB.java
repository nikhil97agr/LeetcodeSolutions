class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int dist = set.size();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int start = 0;
        int end = 0;
        int ans = 0;

        while(end < n){
            add(map, nums[end]);

            while(map.size() == dist){
                ans += (n-end);
                remove(map, nums[start]);
                start++;
            }
            end++;
        }
        return ans;
    }

    private void add(Map<Integer, Integer> map , int val){
        int cnt = map.getOrDefault(val, 0);
        map.put(val, cnt+1);
    }

    private void remove(Map<Integer, Integer> map, int val){
        int cnt = map.get(val);
        if(cnt == 1) map.remove(val);
        else map.put(val, cnt-1);
    }
}