class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        List<Integer> mask = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<1<<n;i++){
            if(Integer.bitCount(i) == n/k){
                mask.add(i);
            }
        }
        Integer dp[] = new Integer[1<<n];
        int ans = solve(mask, nums, 0, (1<<n)-1, n, k, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(List<Integer> mask, int nums[], int currMask, int finalMask, int n, int k, Integer dp[]){


        if(currMask == finalMask){
            return 0;
        }
        if(dp[currMask]!=null) return dp[currMask];
        int ans= Integer.MAX_VALUE;
        for(int m : mask){
            if((currMask & m)!=0){
                continue;
            }
            int min = n + 1;
            int max = 0;
            boolean vis[] =new boolean[n+1];
            boolean res = true;
            for(int i=0;i<n;i++){
                if(((1<<i) & m)==0 ) continue;

                if(vis[nums[i]]){
                    res = false;
                    break;
                }

                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
                vis[nums[i]]= true;


            }

            if(res){
                int temp = solve(mask, nums, currMask | m, finalMask, n, k, dp);

                if(temp != Integer.MAX_VALUE){
                    ans = Math.min(ans, temp + max - min);
                }
            }
        }

        return dp[currMask] = ans;
    }
}