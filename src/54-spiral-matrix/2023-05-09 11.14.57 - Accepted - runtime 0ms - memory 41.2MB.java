class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<Integer>();
        int starti = 0;
        int endi = m-1;
        int startj = 0;
        int endj = n-1;
        int i,j;
        while(starti <= endi && startj <= endj){
            i = starti;
            j = startj;
            while(j<=endj){
                result.add(matrix[i][j]);
                j++;
            }
            starti++;
            i = starti;
            j = endj;
            while(i<=endi){
                result.add(matrix[i][j]);
                i++;
            }
            endj--;
            if(starti>endi || startj>endj) break;

            i =endi;
            j=endj;
            while(j>=startj){
                result.add(matrix[i][j]);
                j--;
            }
            endi--;
            i = endi;
            j = startj;
            while(i>=starti){
                result.add(matrix[i][j]);
                i--;
            }
            startj++;
        }
        return result;
    }
}