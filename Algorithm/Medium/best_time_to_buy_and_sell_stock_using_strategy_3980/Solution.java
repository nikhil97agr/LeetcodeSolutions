package best_time_to_buy_and_sell_stock_using_strategy_3980;

class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long ans = 0;
        int n = prices.length;

        for(int i=0;i<n;i++){
            ans += 1l*prices[i] * strategy[i];
        }

        int start = 0;
        int end = k;
        int mid = k/2;
        long sum = 0;
        for(int i=mid;i<end;i++){
            sum += prices[i];
        }

        for(int i=end;i<n;i++){
            sum += prices[i] * strategy[i];
        }
        ans = Math.max(ans, sum);

        while(end < n){
            sum = sum - prices[end]*strategy[end] + prices[end];
            sum -= prices[mid];
            sum += strategy[start]*prices[start];
            
            ans = Math.max(ans, sum);

            end++;
            mid++;
            start++;
        }


        return ans;

    }
}