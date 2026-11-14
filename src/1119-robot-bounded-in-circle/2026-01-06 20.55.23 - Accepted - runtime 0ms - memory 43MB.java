class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y =0;
        int dir[][] = new int[][]{
            { 0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };
        int i=0;
        for(char c : instructions.toCharArray()){
            if(c== 'G'){
                x += dir[i][0];
                y += dir[i][1];
            }else if(c=='L'){
                i = (i+3)%4;

            }else{
                i = (i+1)%4;
            }
        }

        return (x ==0 && y ==0) || i > 0;
    }
}