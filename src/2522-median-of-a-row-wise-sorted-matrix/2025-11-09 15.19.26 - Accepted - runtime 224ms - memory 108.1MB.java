class Solution {
    public int matrixMedian(int[][] grid) {
        int n = grid.length;
        int m =grid[0].length;
        int total = ((n*m)+1)/2;
        PriorityQueue<Integer> que= new PriorityQueue<>(Collections.reverseOrder());
        for(int x[] : grid){
            for(int y : x){
                que.offer(y);
                if(que.size() > total) que.poll();
            }
        }

        return que.peek();

    }
}