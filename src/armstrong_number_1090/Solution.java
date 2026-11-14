package armstrong_number_1090;

class Solution {
    public boolean isArmstrong(int n) {
        long ans = 0;
        int len = (""+n).length();
        long temp = n;
        while(n > 0){
            long dig = n%10;
            ans += Math.pow(dig, len);
            n/=10;
        }

        return ans == temp;
    }
}