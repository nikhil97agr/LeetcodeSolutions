package maximum_sum_with_exactly_k_elements_2767;

class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for(int x : nums){
            max = Math.max(x, max);
        }
        int total = 0;
        for(int i=0;i<k;i++){
            total += max;
            max++;
        }
        return total;
    }
}