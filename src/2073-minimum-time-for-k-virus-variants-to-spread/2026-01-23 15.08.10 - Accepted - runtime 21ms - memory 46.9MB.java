class Solution {
    public int minDayskVariants(int[][] points, int k) {
        int ans = -1;
        int start = 0;
        int end = 100;
        while(start <= end){
            int mid = (start + end)/2;

            if(check(mid, points, k)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int val, int points[][], int k){
        int cnt[][] =new int[101][101];
        for(int p[] : points){
            int startX = Math.max(0, p[0] - val);
            int endX = Math.min(100, p[0] + val);
            for(int i=startX;i<=endX;i++){
                int left = val - Math.abs(p[0] - i);

                int startY = Math.max(0, p[1] - left);
                int endY = Math.min(100, p[1] + left);
                for(int j=startY;j<=endY;j++){
                    cnt[i][j]++;
                    if(cnt[i][j] == k) return true;
                }
            }
        }

        return false;
    }
}