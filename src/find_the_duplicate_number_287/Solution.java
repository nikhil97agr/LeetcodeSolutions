package find_the_duplicate_number_287;

class Solution {
    public int findDuplicate(int[] nums) {
        for(int x : nums){
            if(nums[Math.abs(x)]<0){
                return x<0 ? -x : x;
            }
            nums[Math.abs(x)] *=-1;
        }
        return -1;
    }
}