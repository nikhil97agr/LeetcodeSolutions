class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2* n];
        int end = 2 * n - 1;
        for(int i=0;i<n;i++){
            ans[i] = ans[end] = nums[i];
            end--;
        }

        return ans;
    }
}