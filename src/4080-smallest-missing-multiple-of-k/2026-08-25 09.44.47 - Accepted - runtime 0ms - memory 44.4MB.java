class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean vis[] = new boolean[101];
        for(int x : nums){
            vis[x] = true;
        }
        int n = k;
        while( n < vis.length && vis[n]){
            n += k;
        }

        return n;
    }
}