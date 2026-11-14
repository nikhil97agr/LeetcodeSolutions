package sort_colors_75;

class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        for(int i=0;i<=right;i++){
            if(nums[i]==0 && i!=left){
                nums[i] = nums[i] + nums[left] - (nums[left]=nums[i]);
                left++;
                i--;
            }else if(nums[i]==2 && i != right){
                nums[i] = nums[i] + nums[right] - (nums[right]=nums[i]);
                right--;
                i--;
            }
        }
    }
}