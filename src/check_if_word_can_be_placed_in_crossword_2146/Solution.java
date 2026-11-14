package check_if_word_can_be_placed_in_crossword_2146;

class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check(board, word.toCharArray(), i, j, m, n)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(char board[][], char ch[], int r, int c, int m, int n){
        if(board[r][c] == '#') return false;
        if(valid(board, r-1, c, m, n) && check(board, ch, r, c, 1, 0, m, n)) return true;

        if(valid(board, r+1, c, m, n) && check(board, ch, r, c, -1, 0, m, n)) return true;

        if(valid(board, r, c+1, m, n) && check(board, ch, r, c, 0, -1, m, n)) return true;

        if(valid(board, r, c-1, m, n) && check(board, ch, r, c, 0, 1, m, n)) return true;

        return false;

    }

    private boolean check(char board[][], char ch[], int r, int c, int dr, int dc, int m, int n){
        int i=0;
        int len = ch.length;

        while ( i < len && valid(r, c, m, n) && (board[r][c] == ' ' || board[r][c] == ch[i])){
            r += dr;
            c += dc;
            i++;
        }

        if( i < len) return false;

        return valid(board, r, c, m, n);
    }

    private boolean valid(int r, int c, int m, int n){
        return r >=0 && r < m && c >=0 && c < n;
    }

    private boolean valid(char board[][], int r, int c, int m, int n){
        if(valid(r, c, m, n)) return board[r][c] == '#';
        return true;
    }
}