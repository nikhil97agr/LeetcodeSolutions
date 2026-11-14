class Solution {
    public int sortArray(int[] nums) {
        int n = nums.length;

        return Math.min(solve(nums, 0, n), solve(nums, 1, n));
    }

    private int solve(int nums[], int start, int n){
        int ans = 0;
        boolean vis[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(nums[i] ==0 || i == nums[i] - start) continue;

            ans++;
            int j = i;
            while(!vis[j] && nums[j] !=0){
                vis[j] = true;
                j = nums[j] - start;
                if(j==i){
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}