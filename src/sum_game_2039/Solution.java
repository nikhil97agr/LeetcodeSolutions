package sum_game_2039;

class Solution {
    public boolean sumGame(String num) {
        double total = 0;
        int n = num.length();
        for(int i=0;i<n;i++){
            total += (i < n/2 ? 1 : -1) * (num.charAt(i) == '?' ? 4.5d : (num.charAt(i) - '0'));
        }

        return total !=0 ;
    }
}