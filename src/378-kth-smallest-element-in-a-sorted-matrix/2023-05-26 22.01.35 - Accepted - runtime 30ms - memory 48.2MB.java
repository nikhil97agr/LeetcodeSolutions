class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> que=  new PriorityQueue<>();
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                que.add(matrix[i][j]);
            }

        }
        while(k>1){
            que.poll();
            k--;
        }
        return que.peek();
    }
}