package determine_color_of_a_chessboard_square_1920;

class Solution {
    public boolean squareIsWhite(String s) {
        char ch = s.charAt(0);
        char dig = s.charAt(1);

        char curr = 'b';
        char ch1 = 'a';
        while(ch1 <ch){
            curr = curr=='b' ? 'w' : 'b';
            ch1++;
        }
        ch1 = '1';
        while(ch1 < dig){
            curr = curr == 'b' ? 'w' : 'b';
            ch1++;
        }

        return curr == 'b' ? false : true;
    }
}