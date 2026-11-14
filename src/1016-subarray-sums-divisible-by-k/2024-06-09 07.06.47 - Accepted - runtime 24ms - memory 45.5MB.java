class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Long, Integer> map = new HashMap<>();

        int cnt = 0;
        long sum = 0;
        map.put(0l,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            long mod = sum%k;
            if(mod < 0){
                mod += k;
            }

            cnt += map.getOrDefault(mod, 0);

            map.put(mod, map.getOrDefault(mod, 0)+1);
        }

        return cnt;
    }
}