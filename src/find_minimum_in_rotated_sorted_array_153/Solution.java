package find_minimum_in_rotated_sorted_array_153;

class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int mid = (start+end)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[start] >= nums[mid]){
                end = mid;
            }else{
                if(nums[end]>=nums[mid]){
                    end =mid;
                }else{
                    start = mid + 1;
                }
            }
        }

        return nums[start];
    }
}