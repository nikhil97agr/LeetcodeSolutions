package count_the_number_of_houses_at_a_certain_distance_ii_3310;

class Solution {
    public long[] countOfPairs(int n, int x, int y) {
        if( x > y){
            return countOfPairs(n, y, x);
        }

        long ans[] = new long[n];
        for(int i=1;i<=n;i++){
            ans[0]+= 2;
            ans[Math.min(i-1, Math.abs(i-y) + x)]--;
            ans[Math.min(n - i, Math.abs( i -x ) + 1 + n - y)]--;
            ans[Math.min(Math.abs(i-x), Math.abs(y-i) + 1)]++;
            ans[Math.min(Math.abs(i-x) + 1, Math.abs(y-i))]++;
            int r = Math.max(x - i, 0) + Math.max(i-y, 0);
            ans[r + (y-x)/2]--;
            ans[r + (y-x+1)/2]--;

        }

        for(int i=1;i<n;i++){
            ans[i] += ans[i-1];
        }

        return ans;
    }
}