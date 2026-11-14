package transform_to_chessboard_798;

class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) ==1 ) return -1;
            }
        }

        int row = 0;
        int col = 0;
        int rSwap = 0;
        int cSwap = 0;

        for(int i=0;i<n;i++){
            row += board[0][i];
            col += board[i][0];

            if(board[i][0] == i%2) rSwap++;
            if(board[0][i] == i%2) cSwap++;

        }

        if(row != n/2 && row != (n+1)/2) return -1;
        if(col !=n/2 && col != (n+1)/2) return -1;

        if(n%2==1){
            if(cSwap%2==1) cSwap = n - cSwap;
            if(rSwap%2==1) rSwap = n- rSwap;
        }else{
            cSwap = Math.min(n-cSwap, cSwap);
            rSwap = Math.min(n-rSwap, rSwap);
        }

        return (cSwap +rSwap)/2;
    }
}