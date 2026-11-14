class Solution {
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int mod = (int)1e9+7;
        int ans = 0;
        for(int x : nums){
            int y = getReverse(x);
            int diff = x-y;
            ans = ans + map.getOrDefault(diff, 0)%mod;
            ans%=mod;
            map.put(diff, map.getOrDefault(diff, 0)+1);
        }


        return ans;
    }

    private int getReverse(int x){
        int ans = 0;
        while(x>0){
            int digit = x%10;
            x/=10;
            ans  = ans*10+digit;
        }

        return ans;
    }
}