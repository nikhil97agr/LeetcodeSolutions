package number_of_ways_to_build_sturdy_brick_wall_2322;

import java.util.*;
class Solution {
    public int buildWall(int height, int width, int[] bricks) {
        List<Integer> possibleCombination = new ArrayList<>();

        dfs(0, width, bricks, possibleCombination,0);
        int maxMask = possibleCombination.stream().max(Integer::compare).orElse(-1);

        if(maxMask==-1) return 0;

        long mod = (long)1e9+7;

        long dp[][] = new long[height][maxMask+1];

        for(int row : possibleCombination){
            dp[0][row] = 1;
        }

        for(int i=1;i<height;i++){
            for(int curr : possibleCombination){
                for(int prev : possibleCombination){
                    if((curr & prev)==0){
                        dp[i][curr] = dp[i][curr] + dp[i-1][prev];

                        dp[i][curr]%=mod;
                    }
                }
            }
        }
        long ans = 0;
        for(long x : dp[height-1]){
            ans += x;
            ans%=mod;
        }

        return (int)ans;
    }

    private void dfs(int currWid, int width, int bricks[], List<Integer> combos, int mask){
        if(width==currWid){
            combos.add(mask);
            return;
        }
        
        if(currWid>=1){
            mask |= (1<<(currWid-1));
        }

        for(int brick : bricks){
            if(currWid + brick <= width){
                dfs(currWid + brick, width, bricks, combos, mask);
            }
        }
    }
}