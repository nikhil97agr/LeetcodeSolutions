package single_element_in_a_sorted_array_540;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int x = 0;
        for(int i : nums){
            x ^=i;
        }

        return x;
        
    }
}