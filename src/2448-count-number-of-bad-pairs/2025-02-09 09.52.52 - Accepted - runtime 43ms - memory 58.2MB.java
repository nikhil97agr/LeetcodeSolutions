class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = (1l*n*(n-1))/2;
        Map<Integer, Long> map = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            int sum = i-nums[i];
            ans -= map.getOrDefault(sum, 0L);
            map.put(sum ,map.getOrDefault(sum, 0L)+1);
        }
        return ans;
    }
    
}