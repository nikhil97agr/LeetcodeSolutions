class Solution {
    public long maxStrength(int[] nums) {
        long ans = 1;
        Arrays.sort(nums);
        int n= nums.length;
        if(nums[0] == 0 && nums[n-1] == 0) return 0L;
        int neg = 0;
        if(n==1) return nums[0];
        for(int i=0;i<n;i++){
            if(nums[i] < 0) neg++;
            if(nums[i] > 0) ans = ans*nums[i];
        }
        if(nums[n-1] == 0 && neg <=1) return 0;

        if(neg%2==0){
            for(int i=0;i<n && neg > 0;i++){
                neg--;
                ans = ans*nums[i];
            }
        }else{
            for(int i=0;i<n && neg > 1 ;i++){
                neg--;
                ans = ans*nums[i];
            }
        }
        return ans;

    }
}