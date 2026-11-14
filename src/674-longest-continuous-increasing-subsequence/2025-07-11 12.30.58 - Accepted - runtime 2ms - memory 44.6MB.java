class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int i=0;
        int cnt = 1;
        while(i < nums.length-1){
            if(nums[i] < nums[i+1]){
                cnt++;
            }else{
                cnt = 1;
            }

            ans = Math.max(ans, cnt);
            i++;
        }

        return ans;
    }
}