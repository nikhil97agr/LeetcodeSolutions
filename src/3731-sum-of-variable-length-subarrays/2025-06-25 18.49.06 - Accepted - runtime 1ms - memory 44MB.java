class Solution {
    public int subarraySum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int start = Math.max(0, i - nums[i]);
            while(start <= i){
                sum += nums[start];
                start++;
            }
        }

        return sum;
    }
}