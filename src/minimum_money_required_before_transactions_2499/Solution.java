package minimum_money_required_before_transactions_2499;

class Solution {
    public long minimumMoney(int[][] transactions) {
        long maxCashback = 0;
        long totalLoss = 0;
        for(int t[] : transactions){
            totalLoss += Math.max((t[0] - t[1]), 0);
            if(t[1] < t[0]){
                maxCashback = Math.max(maxCashback, t[1]);
            }
        }

        for(int t[] : transactions){
            if(t[0] <= t[1]){
                maxCashback = Math.max(maxCashback, t[0]);
            }
        }

        return totalLoss + maxCashback;
        
    }
}