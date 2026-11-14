class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[k];
        int ind = 0;
        for(int i=0;i+k<=n;i++){
            if(nums[i] > nums[ind]){
                ind = i;
            }
        }

        int i =0;
        for(int j=ind;j<ind + k;j++){
            ans[i++] = nums[j];
        }

        return ans;
    }

}