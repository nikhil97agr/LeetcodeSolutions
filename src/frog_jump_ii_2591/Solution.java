package frog_jump_ii_2591;

class Solution {
    public int maxJump(int[] stones) {
        int ans = 0;
        int n = stones.length;
        boolean vis[] = new boolean[n];

        if(n==2){
            return stones[1] - stones[0];
        }
        int i=2;
        ans = stones[2] - stones[0];
        while(i+2 < n){
            ans= Math.max(ans, stones[i] - stones[i-2]);
             vis[i] = true;
            i+=2;
        }

        if(i!=n-1){
            ans = Math.max(ans, stones[n-1] - stones[i]);
            vis[i] = true;
            
        }else{
            ans = Math.max(ans, stones[n-1] - stones[i-2]);
        }

        int k=n-2;
        i = n-1;
        while(k >=0){
            while(vis[k]){
                k--;
            }
            ans = Math.max(ans, stones[i] - stones[k]);
            i =k;
            k--;
        }

        return ans;



    }
}