class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        if(n<=2) return 0;
        int i = 1;
        int diff = nums[1] - nums[0];
        int cnt = 1;
        while(i < n){
            if(cnt >= 3){
                ans += (cnt - 2);
            }
            if(nums[i] - nums[i-1] == diff){
                cnt++;
            }else{
                cnt =2;
                diff = nums[i] - nums[i-1];
            }
            i++;
        }

        if(cnt >=3){
            ans += (cnt - 2);
        }

        return ans;
    }
}