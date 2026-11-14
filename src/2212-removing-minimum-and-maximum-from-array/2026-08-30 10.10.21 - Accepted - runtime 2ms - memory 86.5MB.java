class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minInd = 0;
        int maxInd = 0;
        for(int i=0;i<n;i++){
            if(nums[i] < min){
                min = nums[i];
                minInd = i;
            }

            if(nums[i] > max){
                max = nums[i];
                maxInd = i;
            }

        }
        int totalStart = Math.max(maxInd, minInd)+1;
        int totalEnd = n-Math.min(maxInd, minInd);
        int totalBothSide = Math.min(maxInd, minInd)+1 + (n - Math.max(maxInd, minInd));
        return Math.min(totalStart, Math.min(totalEnd, totalBothSide));

    }
}