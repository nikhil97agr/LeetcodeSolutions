class Solution {
    public int maximumEnergy(int[] energy, int k) {
        
        int ans = Integer.MIN_VALUE;
        int n = energy.length;
        boolean vis[] = new boolean[n];
        for(int i=n-1;i>=0;i--){
            if(vis[i]) continue;
            int sum = 0;
            int j= i;
            while(j>=0){
                sum += energy[j];
                ans = Math.max(ans, sum);
                vis[j] = true;
                j-=k;
            }
        }
        return ans;
        
    }
}