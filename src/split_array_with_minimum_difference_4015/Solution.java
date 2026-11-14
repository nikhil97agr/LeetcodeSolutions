package split_array_with_minimum_difference_4015;

class Solution {
    public long splitArray(int[] nums) {
        long ans = 1000000000000L;
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        long pre[] = new long[n];
        long suf[] = new long[n];
        left[0] = 1;
        pre[0] = nums[0];
        
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]){
                left[i] = left[i-1] + 1;
            }
            pre[i] = pre[i-1] + nums[i];
            
        }
        suf[n-1] = nums[n-1];
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] > nums[i+1]){
                right[i] = right[i+1] + 1;
            }
            suf[i] = suf[i+1] + nums[i];
        }

        for(int i=0;i<n-1;i++){
            int l = left[i];
            int r = right[i+1];

            if(l == i+1 && r == n - i - 1){
                ans = Math.min(ans, Math.abs(suf[i+1] - pre[i]));
            }
            
        }

        
        return ans ==1000000000000L ? -1 : ans;
    }
}