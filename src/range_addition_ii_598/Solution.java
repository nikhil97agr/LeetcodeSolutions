package range_addition_ii_598;

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length ==0) return m*n;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int op[] : ops){
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }
        return minX*minY;
    }
}