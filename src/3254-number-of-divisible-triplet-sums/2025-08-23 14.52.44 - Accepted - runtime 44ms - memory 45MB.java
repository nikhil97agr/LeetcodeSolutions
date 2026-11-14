class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans = 0;

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                int mod = (nums[i] + nums[j])%d;

                int req = 0;
                if(mod !=0){
                    req = d - mod;
                }

                ans += map.getOrDefault(req,0);
            }

            map.merge(nums[i]%d, 1, Integer::sum);
        }

        return ans;
    }
}