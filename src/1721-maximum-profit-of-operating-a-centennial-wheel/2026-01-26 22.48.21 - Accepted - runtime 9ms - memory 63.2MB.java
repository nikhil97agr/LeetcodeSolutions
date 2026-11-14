class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = 0;
        int cost = 0;
        int total = 0;
        int maxCost = 0;
        int maxRun = 0;

        for(int i=0;i<customers.length;i++){
            total += customers[i];

            int req = Math.min(total, 4);

            cost += req*boardingCost - runningCost;
            
            ans++;
            if(cost > maxCost){
                maxRun = ans;
                maxCost = cost;
            }
            total -= req;
        }

        while(total > 0){
            int req = Math.min(total , 4);
            cost += req * boardingCost - runningCost;
            ans++;

            if(cost > maxCost){
                maxCost = cost;
                maxRun = ans;
            }
            total -= req;
        }

        return maxRun ==0 ? -1 : maxRun;
    }
}