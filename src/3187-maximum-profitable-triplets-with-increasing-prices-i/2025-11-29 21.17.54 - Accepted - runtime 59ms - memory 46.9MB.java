class Solution {
    public int maxProfit(int[] prices, int[] profits) {
        int ans = -1;
        int n = prices.length;

        for(int i=1;i<n-1;i++){
            int l= -1;
            int r= -1;

            for(int j=0;j<i;j++){
                if(prices[i] > prices[j]){
                    l = Math.max(l, profits[j]);
                }
            }

            for(int j=i+1;j<n;j++){
                if(prices[j] > prices[i]){
                    r = Math.max(r, profits[j]);
                }
            }

            if(l!=-1 && r !=-1){
                ans= Math.max(ans, l + r + profits[i]);
            }
        }

        return ans;
    }
}