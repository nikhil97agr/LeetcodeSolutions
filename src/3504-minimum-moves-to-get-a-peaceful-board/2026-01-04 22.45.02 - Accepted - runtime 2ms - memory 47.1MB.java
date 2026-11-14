class Solution {
    public int minMoves(int[][] rooks) {
        int ans = 0;
        int n = rooks.length;
        int col[] = new int[n];
        int row[] = new int[n];
        for(int r[] : rooks){
            col[r[1]]++;
            row[r[0]]++;
        }
        
        int ind = 0;
        for(int i=0;i<n;i++){
            while(row[ind] == 0){
                ind++;
            }

            ans += Math.abs(i - ind);
            row[ind]--;
        }
         ind = 0;
        for(int i=0;i<n;i++){
            while(col[ind] == 0){
                ind++;
            }
            ans += Math.abs(i - ind);
            col[ind]--;
        }
        return ans;
    }
}