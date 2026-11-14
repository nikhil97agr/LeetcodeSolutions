
class Solution {
    public int[][] candyCrush(int[][] board) {
        while(true){
            boolean selected[][] = find(board);
            
            boolean cleaned = clean(selected, board);
            if(!cleaned) return board;
            drop(board);

        }
    }
    
    private void drop(int board[][]){
        int n = board.length;
        int m = board[0].length;
        
        for(int j=m-1;j>=0;j--){
            int i=n-1;
            int k = n-1;
            while(i>=0){
                if(board[i][j] !=0){
                    board[k][j] = board[i][j];
                    k--;
                }
                i--;
            }
            while(k>=0){
                board[k][j] = 0;
                k--;
            }
        }
        
        
    }
    
    private boolean clean(boolean selected[][], int board[][]){
        boolean isCleaned = false;
        
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(selected[i][j]){
                    board[i][j] = 0;
                    isCleaned = true;
                }
            }
        }
        
        return isCleaned;
    }

    private boolean[][] find(int board[][]){
        int n = board.length;
        int m = board[0].length;
        boolean selected[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] ==0 ) continue;
                if(i-1 >=0 && i+1 < n && board[i][j] == board[i-1][j] && board[i][j] == board[i+1][j]){
                    selected[i][j] = selected[i+1][j] = selected[i-1][j] = true;
                }
                
                if(j-1 >=0 && j+1 < m && board[i][j] == board[i][j+1] && board[i][j] == board[i][j-1]){
                    selected[i][j] = selected[i][j+1] = selected[i][j-1] = true;
                }
            }
        }
        
        return selected;
    }

}