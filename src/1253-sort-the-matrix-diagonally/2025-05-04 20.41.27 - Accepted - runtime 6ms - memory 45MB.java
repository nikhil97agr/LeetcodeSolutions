class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int ans[][] = new int[m][n];

        for(int i=0;i<m;i++){
            PriorityQueue<Integer> que = new PriorityQueue<>();
            int x=i;
            int y=0;
            while(x < m && y < n){
                que.offer(mat[x][y]);
                x++;
                y++;
            }

            x=i;
            y=0;
            while(x < m && y < n){
                ans[x][y] = que.poll();
                x++;
                y++;
            }
        }

        for(int i=1;i<n;i++){
            PriorityQueue<Integer> que = new PriorityQueue<>();
            int x=0;
            int y=i;
            while(x < m && y < n){
                que.offer(mat[x][y]);
                x++;
                y++;
            }
            x=0;
            y=i;
            while(x < m && y < n){
                ans[x][y] = que.poll();
                x++;
                y++;
            }
        }
        return ans;
    }
}