class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double ans = 0;
        double start = 0d;
        double end = 1d*Integer.MAX_VALUE;
        while(end - start >1e-6){
            double mid = (start + end)/2;

            int cnt = 0;
            for(int i=0;i<stations.length-1;i++){
                int gap = stations[i+1] - stations[i];
                cnt += (gap / mid);
            }

            if(cnt > k){
                start = mid;
            }else{
                ans = mid;
                end = mid;
            }
        }

        return ans;
    }
}