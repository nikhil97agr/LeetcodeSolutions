package sum_of_even_numbers_after_queries_1027;

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int ans = 0;
        int n = nums.length;
        int m = queries.length;
        for(int x : nums){
            if(x%2==0){
                ans += x;
            }
        }
        int result[] = new int[m];
        int ind = 0;
        for(int [] q : queries){
            int i = q[1];
            int val = q[0];
            if(nums[i]%2==0){
                ans -= nums[i];
                
            }
            nums[i] = nums[i] + val;
            if(nums[i]%2==0){
                ans += nums[i];
            }
            
            result[ind++] = ans;
            
        }
        return result;
    }
}