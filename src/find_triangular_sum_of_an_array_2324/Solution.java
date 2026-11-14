package find_triangular_sum_of_an_array_2324;

class Solution {
    public int triangularSum(int[] nums) {
        int n= nums.length;
        
        while(n > 1){
            int ans[] =new int[n-1];

            for(int i=0;i<n-1;i++){
                ans[i] = nums[i] + nums[i+1];
                ans[i] = ans[i]%10;
            }

            n--;
            nums = ans;
        }

        return nums[0];
    }
}