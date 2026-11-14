class Solution {
    public int buyChoco(int[] prices, int money) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int x : prices){
            if(x <= first){
                second =first;
                first = x;
            }else if(x <= second){
                second = x;
            }
        }
        if(first + second <= money) return money -first - second;
        return money;
    }
}