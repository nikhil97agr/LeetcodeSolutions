class Solution {
    public boolean validTicTacToe(String[] board) {
        int x= 0;
        int o = 0;
        for(String s : board){
            for(char c : s.toCharArray()){
                if(c=='X')x++;
                else if(c=='O') o++;
            }
        }
        char b[][] = new char[board.length][];
        for(int i=0;i<board.length;i++){
            b[i] = board[i].toCharArray();
        }
        
        int x1 = triplet(b, 'X');
        int o1 = triplet(b, 'O');
        if(x1 > 0 && o1 > 0 ) return false;
        if(x-o ==0){
            if(x1 > 0) return false;
            return true;
        }

        if(x-o==1){
            if( o1 > 0 ) return false;
            return true;
        }

        
        return false;
    }

    private int triplet(char board[][], char symbol){
        int cnt = 0;
        for(int i=0;i<3;i++){
            if(board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol){
                cnt++;
            }
            if(board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol){
                cnt++;
            }
        }
        if(board[0][0] == symbol && board[1][1] == symbol && board[2][2]==symbol){
            cnt++;
        }

        if(board[0][2] == symbol && board[1][1] == symbol && board[2][0]== symbol){
            cnt++;
        }

        return cnt;
    }
}

/**
 X X X
 O O X
 O O X
 */