class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
       int empty = 0;
        int cnt = 0;
       while(numBottles > 0){
            cnt += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty = empty%numExchange;
       }  
       return cnt;
    }
}