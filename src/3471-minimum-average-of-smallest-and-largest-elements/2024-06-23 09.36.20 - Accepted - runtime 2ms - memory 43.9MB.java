class Solution {
    public double minimumAverage(int[] nums) {
        double res = Double.MAX_VALUE;
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length-1;
        while(start <end){
            double avg = (1d*nums[start] + 1d*nums[end])/2d;
            res = Math.min(res, avg);
            start++;
            end--;
        }
        return res;
    }
}