package partition_array_into_disjoint_intervals_951;

class Solution {
    public int partitionDisjoint(int[] nums) {
        int currMax = Integer.MIN_VALUE;
        int includedMax = Integer.MAX_VALUE;
        int right = -1;
        
        for(int i=0;i<nums.length;i++){
            currMax = Math.max(currMax, nums[i]);
            if(nums[i]<includedMax){
                includedMax = currMax;
                right = i;
            }
        }
        return right+1;
    }
}