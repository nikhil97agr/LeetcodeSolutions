class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            long sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                ans += check(sum, x);
            }
        }

        return ans;
    }

    private int check(long sum, int x){
        if(sum ==0) return 0;

        if(sum%10 != x) return 0;
        while(sum >= 10){
            sum /=10;
        }

        if(sum == x) return 1;
        return 0;
    }
}