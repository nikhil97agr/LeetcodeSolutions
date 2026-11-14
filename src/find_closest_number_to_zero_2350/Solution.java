package find_closest_number_to_zero_2350;

class Solution {
    public int findClosestNumber(int[] nums) {
        int minDiff = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for(int x : nums){
            int diff=  Math.abs(x);
            if(diff < minDiff){
                minDiff = diff;
                ans = x;
            }else if(diff == minDiff){
                ans = Math.max(ans, x);
            }

        }

        return ans;
    }
}