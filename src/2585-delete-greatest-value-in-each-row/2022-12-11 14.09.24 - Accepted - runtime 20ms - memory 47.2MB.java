class Solution {
    public int deleteGreatestValue(int[][] grid) {
     int n = grid.length;
                int m = grid[0].length;

        PriorityQueue<Integer>[] que = new PriorityQueue[n];
        for(int i=0;i<n;i++){
            que[i] = new PriorityQueue<Integer>((a,b)-> b-a);
            for(int j=0;j<m;j++){
                que[i].offer(grid[i][j]);
            }
        }
        
        int ans = 0;
        for(int i=0;i<m;i++){
            int max = -1;
            for(int j=0;j<n;j++){
                    max = Math.max(que[j].poll(), max);
                
            }
            ans += max;
        }
        return ans;
    }
}