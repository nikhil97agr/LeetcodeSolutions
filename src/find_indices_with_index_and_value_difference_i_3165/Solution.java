package find_indices_with_index_and_value_difference_i_3165;

class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int ans[] = new int[]{-1,-1};
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if((j-i)>=indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }
}