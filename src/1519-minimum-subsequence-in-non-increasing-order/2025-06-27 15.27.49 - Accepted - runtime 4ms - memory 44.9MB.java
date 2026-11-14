class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for(int x : nums){
            sum += x;
        }
        int n = nums.length;
        int i= n-1;
        int ans =0;
        for(;i>0;i--){
            ans += nums[i];
            sum -= nums[i];
            if(ans > sum){
                break;
            }
        }
        List<Integer> result = new ArrayList<>();

        for(int j=n-1;j>=i;j--){
            result.add(nums[j]);
        }

        return result;
    }
}