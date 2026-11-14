package array_nesting_565;

import java.util.*;
class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int cnt[] = new int[n];
        Arrays.fill(cnt, -1);
        int ans = 0;
        for(int i=0;i<n;i++){
            if(cnt[i]==-1){
                ans = Math.max(ans,dfs(cnt, i, nums, new boolean[n]));
            }
        }

        return ans;
    }

    private int dfs(int cnt[], int i, int nums[], boolean vis[]){

        if(vis[i]) return 0;

        if(cnt[i]!=-1) return cnt[i];

        vis[i] = true;

        return cnt[i] = 1 + dfs(cnt, nums[i], nums, vis );
    }
}