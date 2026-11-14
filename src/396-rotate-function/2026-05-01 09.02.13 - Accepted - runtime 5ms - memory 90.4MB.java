class Solution {
    public static void main(String[] args) {
        new Solution().maxRotateFunction(new int[]{4,3,2,6});
    }
    public int maxRotateFunction(int[] nums) {
        int ans = 0;
        int add = 0;
        int sub = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sub += nums[i];
            ans += nums[i] * i;
        }
        int start = 0;
        int prev = ans;
        for(int i=0;i<n-1;i++){
            sub -= nums[i];
            add += (n-1) * nums[i] - start;
            start += nums[i];
            prev -= sub;
            ans = Math.max(ans, prev + add);
        }




        return ans;
    }
}