package minimum_total_operations_3694;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int last = nums[n-1];
        int total =0;
        int ans = 0;

        for(int i=n-2;i>=0;i--){
            int num = nums[i] + total;
            if(num!=last){
                total += (last - num);
                ans++;
            }
        }

        return ans;
    }
}