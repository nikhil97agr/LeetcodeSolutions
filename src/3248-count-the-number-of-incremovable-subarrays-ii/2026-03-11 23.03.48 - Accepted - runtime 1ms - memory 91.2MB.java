class Solution {

    public long incremovableSubarrayCount(int[] nums) {

        int n = nums.length;
        int start =0;
        while(start+1< n && nums[start] < nums[start+1]){
            start++;
        }

        if(start == n-1){
            return 1l * n * (n+1)/2;
        }

        long ans = start + 2;

        for(int i=n-1;i>=0;i--){
            if( i < n-1 && nums[i] >= nums[i+1]){
                break;
            }
            while(start >=0 && nums[start] >= nums[i]){
                start--;
            }

            ans += start + 2;
        }
        return ans;


    }
}