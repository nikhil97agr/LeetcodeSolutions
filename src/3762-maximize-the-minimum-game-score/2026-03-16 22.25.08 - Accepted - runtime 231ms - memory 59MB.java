class Solution {
    public long maxScore(int[] points, int m) {
        long ans = 0;
        long start = 0;
        long end = 1l * m * Arrays.stream(points).max().getAsInt();
        int n = points.length;
        while(start <= end){
            long mid = start + (end - start)/2;

            if(possible(mid, points, n,m)){
                ans= mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }

    private boolean possible(long mid, int points[], int n, int m){

        long total[] = new long[n];
        for(int i=0;i<n;i++){
            long left = mid - total[i];

            if(left <= 0){
                m--;
                continue;
            }
            if(m ==0) return false;
            long steps = left / points[i];
            if(mid %points[i] !=0){
                steps++;
            }

            if(2 * steps - 1 <= m){
                m -= (2 * steps - 1);
                if(i < n-1 ){
                    total[i+1] = (steps - 1) * points[i+1];
                }
            }else{
                 return false;
            }

        }

        return true;
    }
}