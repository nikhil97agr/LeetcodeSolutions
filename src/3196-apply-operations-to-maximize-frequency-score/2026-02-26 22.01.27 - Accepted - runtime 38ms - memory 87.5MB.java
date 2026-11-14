class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        int ans = 0;
        int n = nums.length;
        long pre[] = new long[n+1];
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + nums[i];
        }
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = (start + end)/2;
            
            if(possible(mid, pre, nums, k)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        

        return ans;
    }

    private boolean possible(int mid, long[] pre, int[] nums, long k){
        int n = nums.length;

        for(int i = 0; i + mid <= n; i++){
            int medianIdx = i + mid / 2;
            int median = nums[medianIdx];


            long leftOps = (long) median * (medianIdx - i) - (pre[medianIdx] - pre[i]);

            long rightOps = (pre[i + mid] - pre[medianIdx + 1]) - (long) median * (i + mid - medianIdx - 1);

            if(leftOps + rightOps <= k){
                return true;
            }
        }

        return false;
    }
}