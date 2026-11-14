class Solution {
        public int maxProduct(int[] A) {
        int n = A.length;
        int start = 0;
        int end = 0;
        int ans = A[0];
        for(int i=0;i<n;i++){
            start = (start==0?1 : start)*A[i];
            end = (end==0? 1 : end)*A[n-1-i];

            ans = Math.max(ans, Math.max(start, end));
        }

        return ans;
    }
}