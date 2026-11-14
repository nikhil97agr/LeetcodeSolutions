package maximum_difference_between_adjacent_elements_in_a_circular_array_3747;

class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int ans = 0;

        int n =nums.length;
        for(int i=0;i<n;i++){
            int a = nums[i];
            int b = nums[(i+1)%n];
            ans = Math.max(ans, Math.abs(a-b));
        }

        return ans;
    }
}