class Solution {
    public int numberOfCleanRooms(int[][] room) {
        int dir[][] = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };
        int dirIndex = 0;
        int n = room.length;
        int m = room[0].length;
        boolean vis[][][] =new boolean[n][m][4];
        int d = 4;
        int r = 0;
        int c =0;
        int ans = 0;
        while(true){
            vis[r][c][dirIndex] = true;
            int temp[]= move(r, c, dir[dirIndex], room, n, m);
            ans += temp[0];
            r = temp[1];
            c = temp[2];
            dirIndex++;
            dirIndex %= d;
            if(vis[r][c][dirIndex]) return ans == 0 ? 1 : ans;

        }

        

    }

    private int[] move(int r, int c, int dir[], int room[][], int n, int m){
        int cnt = room[r][c] == 0 ? 1 : 0;
        room[r][c] = -1;
        int dr = dir[0];
        int dc = dir[1];
        while(r +dr >=0 && c + dc >=0 && r + dr < n && c + dc < m && room[r+dr][c+dc]!=1){
            if(room[r][c] == 0){
                cnt++;
            }
            room[r][c] = -1;
            r+=dr;
            c+=dc;
        }

        return new int[]{cnt, r, c};
    }
}