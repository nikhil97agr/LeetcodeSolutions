class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int max[] = new int[n];

        max[n-1] = n-1;
        int ind = n-1;
        for(int i=n-1;i>=0;i--){
            max[i]= ind;
            if(nums[ind] <= nums[i]){
                ind= i;
            }
        }

        int ans=0;
        int start = 0;
        while(start != n-1){
            ind= max[start];
            ans += (ind - start) * nums[ind];
            start = ind;
        }

        return ans;


    }
}