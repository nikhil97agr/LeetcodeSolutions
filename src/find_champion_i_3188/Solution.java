package find_champion_i_3188;

class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int cnt[] = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    cnt[j]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(cnt[i] ==0) return i;
        }
        return -1;
    }
}