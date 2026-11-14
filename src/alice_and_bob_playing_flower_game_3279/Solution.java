package alice_and_bob_playing_flower_game_3279;

class Solution {
    public long flowerGame(int n, int m) {
        long ans = 0;
        
        long e1 = n/2;
        long o1 = n - e1;
        
        long e2 = m/2;
        long o2 = m - e2;
        
        
        return e1*o2 + o1*e2;
    }
}