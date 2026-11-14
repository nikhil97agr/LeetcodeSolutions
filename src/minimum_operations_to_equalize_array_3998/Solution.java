package minimum_operations_to_equalize_array_3998;

class Solution {
    public int minOperations(int[] nums) {
       int prev = nums[0];

       for(int x : nums){
        if(prev !=x) return 1;
       } 

       return 0;
    }
}