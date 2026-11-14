class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Integer> que= new PriorityQueue<>();
        que.offer(matrix[0][0]);
        for(int i=1;i<n;i++){
            matrix[i][0] = matrix[i][0] ^ matrix[i-1][0];
            que.offer(matrix[i][0]);
            if(que.size() > k) que.poll();
        }
        for(int i=1;i<m;i++){
            matrix[0][i] = matrix[0][i] ^ matrix[0][i-1];
            que.offer(matrix[0][i]);
            if(que.size() > k) que.poll();
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                matrix[i][j] = matrix[i][j] ^ matrix[i-1][j] ^ matrix[i][j-1] ^ matrix[i-1][j-1];

                que.offer(matrix[i][j]);

                if(que.size() > k) que.poll();
            }
        }

        return que.peek();
    }
}