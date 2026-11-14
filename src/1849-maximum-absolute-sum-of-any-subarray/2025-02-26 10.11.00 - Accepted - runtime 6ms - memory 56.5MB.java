class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currMin = 0;
        int min  = Integer.MAX_VALUE;
        int currMax = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            currMin = Math.min(currMin+num, num);
            min = Math.min(min, currMin);
            
            currMax = Math.max(currMax+num, num);
            max = Math.max(max, currMax);
        }
        
        return Math.max(Math.abs(min), max);
    }
    
}