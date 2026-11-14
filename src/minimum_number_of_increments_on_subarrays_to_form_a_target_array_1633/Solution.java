package minimum_number_of_increments_on_subarrays_to_form_a_target_array_1633;

class Solution {
    public int minNumberOperations(int[] target) {
        int ans = target[0];
        for(int i=1;i<target.length;i++){
            ans+= Math.max(0, target[i] - target[i-1]);
        }
        return ans;
    }
}