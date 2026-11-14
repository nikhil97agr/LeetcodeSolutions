class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        long ans = Long.MIN_VALUE;

        int n = nums.length;

        for(int i=0;i<n;i++){
            int key = nums[i] - i;
            if(nums[i] <= 0){
                ans = Math.max(ans, nums[i]);
                continue;
            }

            var floor = map.floorEntry(key);
            long curr = nums[i];
            if(floor != null){
                curr += floor.getValue();
            }

            var ceiling = map.ceilingEntry(key);
            while(ceiling != null && ceiling.getValue() <= curr){
                map.remove(ceiling.getKey());
                ceiling = map.ceilingEntry(key);
            }

            floor = map.floorEntry(key);

            if(floor == null || floor.getValue() < curr){
                map.put(key, curr);
            }

            ans= Math.max(ans, curr);
        }

        return ans;
    }


}

/**
i > j
=> nums[i] - nums[j] >= i - j
=> nums[i] - i >= nums[j] - j

 */