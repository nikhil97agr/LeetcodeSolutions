class Solution {
    int index;
    int rect[][];
    int x;
    int y;
    int n;
    public Solution(int[][] rects) {
        rect = rects;
        n = rect.length;
        x = rect[index][0];
        y = rect[index][1];
    }
    
    public int[] pick() {
        if(x == rect[index][2] && y == rect[index][3]){
            index++;
            index%=n;
            x = rect[index][0];
            y = rect[index][1];
        }else if(rect[index][2] == x){
            x = rect[index][0];
            y++;
        }else{
            x++;
        }

        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */