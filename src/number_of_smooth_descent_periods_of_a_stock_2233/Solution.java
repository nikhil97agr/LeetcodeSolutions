package number_of_smooth_descent_periods_of_a_stock_2233;

class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 1;
        long total = 0;
        int n = prices.length;
        if(n==1){
            return 1;
        }
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]==-1){
                count++;
            }else{
                total += count*(count-1)/2;
                count = 1;
            }
        }
        total += count*(count-1)/2;
        total +=n;
        return total;
    }
}