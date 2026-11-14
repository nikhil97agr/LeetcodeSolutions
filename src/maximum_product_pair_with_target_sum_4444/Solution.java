package maximum_product_pair_with_target_sum_4444;

class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int prod = -100000;
        int n = nums.length;
        int i1 = -1;
        int j1 = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(nums[i] > nums[j] && nums[i] + nums[j] == target){
                    int p = nums[i] * nums[j];
                    if( p > prod){
                        prod = p;
                        i1 = i;
                        j1 = j;
                    }
                }
            }
        }

        return new int[]{i1, j1};
    }
}