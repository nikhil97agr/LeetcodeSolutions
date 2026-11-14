class Solution {
    boolean vis[][][];
    public boolean canReach(int[] start, int[] target) {

        vis =new boolean[8][8][131];
        return check(start[0], start[1], target[0], target[1], 0);
    }

    private boolean check(int x1, int y1, int x2, int y2, int move){
        if(x1 == x2 && y1 == y2 && move%2==0 ){
            
            return true;
        }

        if( x1 < 0 || y1 < 0 || x1 > 7 || y1 > 7 || move > 130){
            return false;
        }

        if(vis[x1][y1][move]) return false;
        vis[x1][y1][move] = true;

        int dir[][] = new int[][]{{1, -2}, {1, 2}, {-1, -2}, {-1, 2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        for(var d : dir){
            if(check(x1 + d[0], y1 + d[1], x2, y2, move + 1)) return true;
        }

        return false;

    }
}