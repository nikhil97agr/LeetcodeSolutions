package stone_removal_game_3625;

class Solution {
    public boolean canAliceWin(int n) {
        int start = 10;

        char turn = 'a';

        while(n>=start){
            if(turn == 'a'){
                turn = 'b';
            }else{
                turn = 'a';
            }
            n-=start;
            start--;
        }

        return turn == 'b';
    }
}