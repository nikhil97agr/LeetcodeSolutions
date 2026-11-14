class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0;
        int n = nuts.length;
        for(int i=0;i<n;i++){
            sum += 2 * sum(tree, nuts[i]);
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int d1 = sum(tree, nuts[i]);
            int d2 = sum(squirrel, nuts[i]);

            ans = Math.min(ans, sum - d1 + d2);
        }

        return ans;
    }

    private int sum(int a[], int b[]){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
