package row_with_maximum_ones_2737;

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int cnt = 0;
        int row = 0;
        for(int i=0;i<mat.length;i++){
            int c = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] ==1) c++;
            }

            if(c > cnt){
                row = i;
                cnt = c;
            }
        }

        return new int[]{row, cnt};
    }
}