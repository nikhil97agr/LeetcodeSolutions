class Solution {
    public int countSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] > k){
                nums[i] = 1;
            }else if(nums[i] < k){
                nums[i] = -1;
            }else{
                nums[i] = 0;
            }
        }

        boolean found = false;
        int sum = 0;
        int ans = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
            if(nums[i] == 0) found = true;

            if(!found){
                map.merge(sum, 1, Integer::sum);
            }else{
                if(sum ==0 || sum == 1){
                    ans++;
                }
                ans += map.getOrDefault(sum, 0) + map.getOrDefault(sum-1, 0);
            }
        }

        return ans;
    }
}