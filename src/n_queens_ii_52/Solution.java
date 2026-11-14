package n_queens_ii_52;

import java.util.*;
class Solution {
    public int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for(char b[] : board){
            Arrays.fill(b, '.');
        }

        List<List<String>> result = new ArrayList<>();
        solve(board, result, 0, n);
        return result.size();
    }

    private void solve(char board[][], List<List<String>> result, int i,  int n){
        if(i==n){
            List<String> temp = new ArrayList<>();
            for(char c[] : board){
                temp.add(new String(c));
            }
            result.add(temp);
            return;
        }

        for(int j=0;j<n;j++){
            board[i][j]='Q';
            if(safe(board, i, j, n)){
                solve(board, result, i+1, n);
            }

            board[i][j]='.';
        }
    }

    private boolean safe(char board[][], int i, int j, int n){
        for(int k=0;k<n;k++){
            if(k!=i && board[k][j]=='Q'){
                return false;

            }
            if(k!=j && board[i][k]=='Q'){
                return false;
            }
        }
        int r = i+1;
        int c = j+1;
        while(r<n && c<n){
            if(board[r][c]=='Q'){
                return false;
            }

            r++;
            c++;
        }

        r = i-1;
        c = j-1;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c--;
        }

        r = i-1;
        c = j+1;
        while(r>=0 && c<n){
            if(board[r][c]=='Q'){
                return false;
            }

            r--;
            c++;
        }

        r = i+1;
        c = j-1;
        while(r<n && c >=0){
            if(board[r][c]=='Q'){
                return false;
            }

            r++;
            c--;
        }
        return true;
    }
}