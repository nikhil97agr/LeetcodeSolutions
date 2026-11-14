class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int pref[] = new int[n];
        int suf[] = new int[n];

        for(int i=1;i<n;i++){
            pref[i]= Math.max(pref[i-1], nums[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            suf[i] = Math.max(suf[i+1], nums[i+1]);
        }

        long ans = 0;

        for(int i=1;i<n-1;i++){
            ans = Math.max(ans, 1l*(pref[i] - nums[i])*suf[i]);
        }

        return ans;
    }
}