package richest_customer_wealth_1791;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            int cnt = 0;
            for(int x : accounts[i]){
                cnt += x;
            }
            ans = ans >= cnt ? ans : cnt;
        }
        return ans;
    }

}