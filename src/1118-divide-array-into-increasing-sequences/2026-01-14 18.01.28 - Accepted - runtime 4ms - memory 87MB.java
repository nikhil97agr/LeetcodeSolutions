class Solution {
    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int cnt = 0;
        int prev = nums[0];
        int n = nums.length;
        int max = 0;
        for(int x : nums){
            if(x == prev) cnt++;
            else{
                if(cnt > max) max = cnt;
                prev = x;
                cnt = 1;
            }
        }

        max = Math.max(max, cnt);
        if(max * k > n)return false;
        
        return true;


    }
}