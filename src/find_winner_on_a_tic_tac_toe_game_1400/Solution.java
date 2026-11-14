package find_winner_on_a_tic_tac_toe_game_1400;

import java.util.*;
class Solution {
    public String tictactoe(int[][] moves) {
        char grid[][] = new char[3][3];
        for(int i=0;i<3;i++){
            Arrays.fill(grid[i], ' ');
        }
        char next = 'X';
        for(int m[]: moves){
            grid[m[0]][m[1]] = next;
            next = next == 'X' ? 'O' : 'X';
        }

        if(check(grid, 'X')) return "A";
        if(check(grid, 'O')) return "B";

        if(empty(grid)) return "Pending";
        return "Draw";
    }

    private boolean empty(char grid[][]){
        for(char ch[]: grid){
            for(char c : ch){
                if(c==' ') return true;
            }
        }

        return false;
    }

    private boolean check(char grid[][], char search){
        for(int i=0;i<3;i++){
            int cnt = 0;
            for(int j=0;j<3;j++){
                if(grid[i][j] == search) cnt++;
            }
            if(cnt == 3) return true;
            cnt=0;
            for(int j=0;j<3;j++){
                if(grid[j][i] == search){
                    cnt++;
                }
            }
            if(cnt == 3) return true;
        }

        int cnt = 0;
        for(int i=0,j=0;i<3;i++,j++){
            if(grid[i][j] == search){
                cnt++;
            }
        }

        if(cnt ==3 ) return true;
        cnt = 0;
        for(int i=0, j=2;i<3;i++,j--){
            if(grid[i][j] == search){
                cnt++;
            }
        }


        return cnt == 3;


    }
}