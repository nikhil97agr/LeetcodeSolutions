package check_if_move_is_legal_2080;

class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;
        
        return check(board, rMove, cMove, 0, 1, color)
        || check(board, rMove, cMove, 0, -1, color)
        || check(board, rMove, cMove, 1, 0, color)
        || check(board, rMove, cMove, -1, 0, color)
        || check(board, rMove, cMove, 1, 1, color)
        || check(board, rMove, cMove, 1, -1, color)
        || check(board, rMove, cMove, -1, 1, color)
        || check(board, rMove, cMove, -1, -1, color);
        
    }

    private boolean check(char board[][], int rMove, int cMove, int r, int c, char color){  
        boolean seen = false;
        rMove += r;
        cMove += c;
        while(rMove >=0 && cMove >=0 && rMove < 8 && cMove < 8){
            if(board[rMove][cMove] == '.') return false;
            if(board[rMove][cMove] == color) return seen;

            seen = true;
            rMove +=r;
            cMove += c;
        }

        return false;
    }
}