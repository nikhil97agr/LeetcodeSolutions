package calculate_money_in_leetcode_bank_1817;

class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int monday = 0;
        int prev = 1;
        int days = 0;
        while(n-->0){
            if(days ==0){
                prev = monday+1;
                monday = prev;
            }
            total += prev;
            prev++;
            days++;
            days%=7;
        }

        return total;
    }
}