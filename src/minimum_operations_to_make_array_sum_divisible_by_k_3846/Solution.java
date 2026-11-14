package minimum_operations_to_make_array_sum_divisible_by_k_3846;

class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int x : nums) sum += x;

        return sum%k;
    }
}