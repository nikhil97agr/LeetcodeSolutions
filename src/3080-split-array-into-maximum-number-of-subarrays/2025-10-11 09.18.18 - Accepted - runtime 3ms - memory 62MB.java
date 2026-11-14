class Solution {
    public int maxSubarrays(int[] nums) {
        int min = nums[0];
        for(int x : nums) min &= x;

        if(min!=0) return 1;

        int ans = 0;
        int n = nums.length;

        int i=0;
        while(i< n){
            int val = nums[i];
            i++;
            while(i< n && val > 0){
                val &= nums[i];
                i++;
            }
            if(val==0){
                ans++;

            }else{
                return ans;
            }


        }

        return ans;
        
    }
}