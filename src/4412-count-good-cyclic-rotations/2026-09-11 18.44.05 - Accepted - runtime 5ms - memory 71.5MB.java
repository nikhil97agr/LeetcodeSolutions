class Solution {
    public int countGoodRotations(int[] nums) {
        long sumFirst = 0;
        int n = nums.length;
        int ans = 0;
        long sumEnd = 0;

        int mid = n / 2;
        for(int i=0;i<n/2;i++){
            sumFirst += nums[i];
            sumEnd += nums[i + mid];
        }

        for(int i=0;i<n;i++, mid++){
            mid%=n;

            if(sumFirst > sumEnd){
                ans++;
            }

            sumFirst -= nums[i];
            sumEnd += nums[i];
            sumFirst += nums[mid];
            sumEnd -= nums[mid];
        }

        return ans;
    }
}