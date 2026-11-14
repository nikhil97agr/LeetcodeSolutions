class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i+k<=n;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<i+k;j++){
                set.add(nums[j]);
            }

            for(int x : set){
                int cnt = map.getOrDefault(x, 0);
                map.put(x, cnt + 1);
            }
        }

        int ans = -1;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                ans = Math.max(ans, entry.getKey());
            }
        }
        return ans;
    }
}