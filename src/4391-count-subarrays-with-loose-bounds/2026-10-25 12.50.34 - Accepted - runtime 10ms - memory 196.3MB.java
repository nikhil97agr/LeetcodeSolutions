class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        long cnt = 0;
        for(int x : nums){
            if(x >= minK && x <= maxK){
                cnt++;
            }else{
                ans += (cnt *( cnt + 1))/2;
                cnt = 0;
            }
        }

        return ans + (cnt * (cnt + 1))/2;
    }
}