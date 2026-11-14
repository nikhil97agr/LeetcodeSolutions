package minimum_element_after_replacement_with_digit_sum_3606;

class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for(int x : nums){
            int dig = 0;
            while(x > 0){
                dig += x%10;
                x/=10;
            }
            ans = Math.min(ans, dig);
        }

        return ans;
    }
}