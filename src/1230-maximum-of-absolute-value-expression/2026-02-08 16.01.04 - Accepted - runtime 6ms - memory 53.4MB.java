class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int comb[][] = {
            {1, 1,1}, {1,1,-1},
            {1,-1,1}, {1,-1,-1},
            {-1,1,1}, {-1,1,-1},
            {-1,-1,1}, {-1, -1, -1}
        };
        int n =arr1.length;
        int ans = Integer.MIN_VALUE;
        for(int c[] : comb){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i=0;i<n;i++){
                int sum = arr1[i] * c[0] + arr2[i] * c[1] + i * c[2];
                min = Math.min(min, sum);
                max = Math.max(max, sum);
            }

            ans = Math.max(ans, max- min);
        }

        return ans;
    }
}