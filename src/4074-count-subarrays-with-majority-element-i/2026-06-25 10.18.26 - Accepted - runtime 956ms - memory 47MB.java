class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            Map<Integer, Integer> map = new HashMap<>();
            int len = 0;
            for(int j=i;j<n;j++){
                map.merge(nums[j], 1, Integer::sum);
                int cnt = map.getOrDefault(target, 0);
                len++;
                if(cnt > len / 2)ans++;
            }

        
        }
        return ans;
    }
}