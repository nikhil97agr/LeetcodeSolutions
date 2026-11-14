class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;  
        
        long[] pre = new long[n]; 
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        Map<Integer, Long> map =new HashMap<>();

        map.put(0, 0l);

        

        for(int i=0;i<n;i++){
            int ind = (i+1)%k;
            if(map.containsKey(ind)){
                ans = Math.max(ans, pre[i] - map.get(ind));
            }
            
            map.put(ind, Math.min(map.getOrDefault(ind, Long.MAX_VALUE), pre[i]));
        }

        return ans;
    }
}