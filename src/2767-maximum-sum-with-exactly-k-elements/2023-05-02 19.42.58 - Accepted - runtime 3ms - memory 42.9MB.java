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