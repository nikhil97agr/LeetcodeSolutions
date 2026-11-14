package search_in_rotated_sorted_array_ii_81;

class Solution {
    public boolean search(int[] nums, int target) {
        for(int x : nums){
            if(x==target){
                return true;
            }
        }
        return false;
    }
}