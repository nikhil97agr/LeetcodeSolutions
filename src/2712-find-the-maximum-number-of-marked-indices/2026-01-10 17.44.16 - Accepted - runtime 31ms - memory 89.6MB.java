class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = (n + 1) / 2;
        int ans = 0;
        while (j < n) {
            if (2 * nums[i] <= nums[j]) {
                ans += 2;
                i++;
            }
            j++;
        }

        return ans;
    }
}