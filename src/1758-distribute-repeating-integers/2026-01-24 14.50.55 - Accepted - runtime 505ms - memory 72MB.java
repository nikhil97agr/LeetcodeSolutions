class Solution {
    Boolean dp[][];
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.merge(x, 1, Integer::sum);
        List<Integer> list = new ArrayList<>(map.values());
        dp = new Boolean[1<<quantity.length][list.size()];
        return solve(0, quantity.length, quantity, 0, list, (1<<quantity.length)-1);
    }

    private boolean solve(int mask, int n, int nums[], int i, List<Integer> list, int finalMask){
        if(mask == finalMask) return true;
        if(i == list.size()) return false;

        if(dp[mask][i]!=null) return dp[mask][i];
        for(int m = 1;m<1<<n;m++){
            if((mask & m )!=0) continue;

            int total =0;
            for(int j=0;j<n;j++){
                if((m & (1<<j))!=0){
                    total += nums[j];
                }
            }

            if(total <= list.get(i)){
                if(solve(mask | m, n, nums, i+1, list, finalMask)) return true;
            }
        }

        return dp[mask][i] = solve(mask, n, nums, i+1, list, finalMask);
    }
}