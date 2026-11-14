class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        Integer dp[] = new Integer[n];
        return solve(nums, k, n, 0, dp);
    }

    private int solve(int nums[], int k, int n, int i, Integer dp[]){
        if(i==n) return 0;
        if(dp[i] !=null) return dp[i];
        int len = 0;
        HashMap<Integer, Integer> map =new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for(int j=i;j<n;j++){
            if(map.containsKey(nums[j])){
                if(map.get(nums[j]) ==1){
                    len++;
                }
                len++;
                map.merge(nums[j], 1, Integer::sum);
            }else{
                map.put(nums[j], 1);
            }

            ans = Math.min(ans, k + len + solve(nums, k, n, j+1, dp));
        }

        return dp[i] = ans;
    }
}