class Solution {
    public int minOperations(int[] nums) {
       int prev = nums[0];

       for(int x : nums){
        if(prev !=x) return 1;
       } 

       return 0;
    }
}