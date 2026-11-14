class Solution {
    public int maximumGroups(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        long prevSum = 0;
        int nextLen = 1;
        int len = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            len++;
            if (len >= nextLen && sum > prevSum) {
                nextLen = len + 1;
                prevSum = sum;
                ans++;
                sum = 0;
                len = 0;
            }
        }

        return Math.max(ans, 1);
    }
}