class Solution {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i=0;i<n;i+=2){
            total +=nums[i];
        }
        int ans[] = new int[total];
        int ind = 0;
        for(int i=0;i<n;i+=2){
            for(int j=0;j<nums[i];j++){
                ans[ind++] = nums[i+1];
            }
        }
        return ans;
    }
}