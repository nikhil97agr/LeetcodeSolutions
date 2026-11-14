class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] < k) cnt++;
            else break;
        }
        return cnt;
    }
}