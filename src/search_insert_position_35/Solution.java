package search_insert_position_35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int ind = -1;
        int ind2 = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ind = i;
                break;
            }
            if(nums[i]<target){
                ind2 = i;
            }


        }

        if(ind!=-1){
            return ind;
        }
        return ind2+1;
    }
}