package apply_operations_to_make_all_array_elements_equal_to_zero_2878;

class Solution {
    public boolean checkArray(int[] nums, int k) {
        int curr = 0;
        for(int i=0;i<nums.length;i++){
            if(curr > nums[i]){
                return false;
            }

            nums[i] -= curr;
            curr += nums[i];

            if( i >= k-1){
                curr -= nums[i-k+1];
            }

        }

        return curr ==0;
    }
}