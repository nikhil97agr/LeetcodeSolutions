package partition_array_into_two_equal_product_subsets_3843;

class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length;
    
        return solve(nums, 1, 1, n, target, 0);
    }

    private boolean solve(int nums[], long prod1, long prod2, int n, long target, int i){
        if(i==n){
            return prod1 == target && prod2 == target;
        }

        return solve(nums, prod1 * nums[i], prod2, n, target, i+1) || solve(nums, prod1, prod2*nums[i], n, target, i+1);
            }
}