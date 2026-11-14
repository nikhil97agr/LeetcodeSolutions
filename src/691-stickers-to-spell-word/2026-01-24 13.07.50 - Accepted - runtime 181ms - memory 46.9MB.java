class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int finalMask = (1<<n)-1;
        Integer dp[] = new Integer[finalMask + 1];
        int ans= solve(stickers,target.toCharArray(), 0, finalMask, n, dp);

        return ans == Integer.MAX_VALUE? -1 : ans;
    }

    private int solve(String stickers[], char target[], int mask, int finalMask, int n, Integer dp[]){
        if(mask == finalMask) return 0;

        if(dp[mask] !=null) return dp[mask];
        int ans = Integer.MAX_VALUE;

        for(String s : stickers){
            int newMask = mask;
            for(char c : s.toCharArray()){
                for(int i=0;i<n;i++){
                    if((newMask & (1<<i))!=0) continue;

                    if(target[i] != c) continue;

                    newMask |= (1<<i);
                    break;
                }
            }
            if(newMask == mask) continue;
            int temp = solve(stickers, target, mask | newMask, finalMask, n, dp);
            if(temp != Integer.MAX_VALUE){
                ans = Math.min(ans, 1 + temp);
            }
        }

        return dp[mask] = ans;
    }
}