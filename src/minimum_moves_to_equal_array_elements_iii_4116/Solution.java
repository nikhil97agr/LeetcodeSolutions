package minimum_moves_to_equal_array_elements_iii_4116;

class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        for(int x : nums) max = Math.max(max, x);
        int ans = 0;
        for(int x : nums){
            ans += max - x;
        }

        return ans;
    }
    
}