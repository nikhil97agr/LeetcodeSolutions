class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long ans = 0;
        int degree[] = new int[n];
        for(int r [] : roads){
            degree[r[0]]++;
            degree[r[1]]++;
        }

        Arrays.sort(degree);

        int max = n;

        for(int i=n-1;i>=0;i--){
            ans += 1L*degree[i]*max;
            max--;
        }
        return ans;
    }
}