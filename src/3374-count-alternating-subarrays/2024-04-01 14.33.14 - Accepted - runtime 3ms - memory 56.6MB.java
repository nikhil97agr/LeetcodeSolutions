class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 0;
        int size = 1;
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] != prev){
                size++;
                prev = nums[i];
            }else{
                ans += (1L*size*(size+1))/2L;
                prev = nums[i];
                size = 1;
            }
        }
        ans += (1L*size*(size+1))/2L;
        return ans;
    }
}