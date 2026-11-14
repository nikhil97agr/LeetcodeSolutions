package find_peak_element_162;

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        return findPeak(nums, 0, nums.length-1);
    }
    private int findPeak(int nums[], int start, int end){
        if(start==end){
            if(start==0){
                return (nums[start]>nums[start+1])? start : -1;
            }
            if(start == nums.length-1){
                return (nums[start]> nums[start-1]) ? start : -1;
            }

            return (nums[start]>nums[start+1] && nums[end]>nums[end-1]) ? start : -1;
        }

        int mid = start + (end-start)/2;

        int ind1 = findPeak(nums, start, mid);
        if(ind1!=-1){
            return ind1;
        }

        return findPeak(nums, mid+1, end);

        
    }
}