class Solution {
    public int lateFee(int[] daysLate) {
        int ans = 0;
        for(int x : daysLate){
            if(x == 1){
                ans++;
            }else if(2 <= x && x <= 5){
                ans += 2*x;
            }else{
                ans += 3*x;
            }
        }

        return ans;
    }
}