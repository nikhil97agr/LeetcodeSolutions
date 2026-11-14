class Solution {
    public long maxRunTime(int n, int[] batteries) {

        long low = 0;
        long high = (Arrays.stream(batteries).mapToLong(a -> (long) a).sum())/n;

        while(low < high){
            long mid = (high+low+1)/2;

            long totalTimeByBattery = Arrays.stream(batteries).mapToLong(a -> Math.min(a, mid)).sum();

            if(totalTimeByBattery >= mid*n){
                low = mid;
            }else{
                high = mid-1;
            }
        }

        return low;
    }
}