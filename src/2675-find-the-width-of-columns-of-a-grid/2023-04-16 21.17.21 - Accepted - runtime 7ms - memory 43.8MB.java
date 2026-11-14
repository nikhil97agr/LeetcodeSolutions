class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max[] = new int[n];
        for(int i=0;i<n;i++){
            int ans = 0;
            for(int j=0;j<m;j++){
                String x = ""+grid[j][i];
                ans = Math.max(ans, x.length());
            }
            
            max[i] = ans;
        }
        
        return max;
    }
}