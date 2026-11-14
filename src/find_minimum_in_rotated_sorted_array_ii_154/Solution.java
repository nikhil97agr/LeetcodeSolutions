package find_minimum_in_rotated_sorted_array_ii_154;

class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid ;
            }else{
                if(nums[mid] == nums[left]){
                    left++;
                    right--;
                }else{
                    right = mid;
                }
            }
        }

        return nums[left];
    }
}