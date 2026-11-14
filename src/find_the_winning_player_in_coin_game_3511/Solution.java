package find_the_winning_player_in_coin_game_3511;

class Solution {
    public String losingPlayer(int x, int y) {
        String turn = "Alice";

        while(true){
            if(x==0 || y < 4){
                return turn == "Alice" ? "Bob" : "Alice";
            }

            if(turn.equals("Alice")){
                turn = "Bob";
            }else{
                turn = "Alice";
            }
            x--;
            y-=4;
        }
    }
}