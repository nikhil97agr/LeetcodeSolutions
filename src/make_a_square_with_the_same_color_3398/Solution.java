package make_a_square_with_the_same_color_3398;

class Solution {
    public boolean canMakeSquare(char[][] grid) {
        if(check(0,1,0,1, grid)) return true;
        if(check(0,1,1,2, grid)) return true;
        if(check(1,2,0,1, grid)) return true;
        if(check(1,2, 1,2, grid)) return true;
        return false;
    }
    
    
    private boolean check(int starti, int endi, int startj, int endj, char grid[][]){
        int b = 0;
        int w = 0;
        while(starti<=endi){
            int j = startj;
            while(j <= endj){
                if(grid[starti][j]=='B') b++;
                else w++;
                    j++;
            }
            starti++;
        }
        return b==0 || w==0 || b==1 || w==1;
    }
}