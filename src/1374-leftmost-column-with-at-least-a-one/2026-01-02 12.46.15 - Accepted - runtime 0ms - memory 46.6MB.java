/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int m = dim.get(0);
        int n = dim.get(1);
        int ans = n;

        for(int i=0;i<m;i++){
            int start = 0;
            int end = n - 1;
            while(start <= end){
                int mid = (start+end)/2;
                int val = binaryMatrix.get(i, mid);

                if(val == 1){
                    ans = Math.min(ans, mid);
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }



        return ans == n ? -1 : ans;
    }
}