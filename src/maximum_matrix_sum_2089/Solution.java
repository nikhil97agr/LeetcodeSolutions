package maximum_matrix_sum_2089;

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int min = Integer.MAX_VALUE;
        int negCount = 0;
        for(int x[] : matrix){
            int cnt = 0;
            for(int y : x){
                if(y < 0){
                    cnt++;
                }
                min = Math.min(min, Math.abs(y));
                ans += Math.abs(y);
            }
            if(cnt%2==1){
                negCount++;
            }
        }

        if(negCount%2==0){
            return ans;
        }

        return ans - 2*min;


    }
}