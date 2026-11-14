class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int cnt[] = new int[n];
        for(int i=0;i<n;i++){
            int c = 0;
            for(int j=n-1;j>=0 && grid[i][j] == 0;j--){
                c++;
            }

            cnt[i] = c;
        }
        int ans = 0;

        for(int i=0;i<n;i++){
            int req = n - (i + 1);
            int ind = -1;
            for(int j=i;j<n;j++){
                if(cnt[j] >= req){
                    ind = j;
                    break;
                }
            }

            if(ind == -1) return -1;
            for(int j=ind;j > i;j--){
                int temp = cnt[j-1];
                cnt[j-1] = cnt[j];
                cnt[j] = temp;
                ans++;
            }
        }

        return ans;
    }
}