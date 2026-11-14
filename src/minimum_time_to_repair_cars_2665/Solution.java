package minimum_time_to_repair_cars_2665;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long start = 0;
        long end = 0;
        for(int r : ranks){
            end = Math.max(end, 1l*cars*cars*r);
        }
        long ans = 0;
        while(start <= end){
            long mid = (start + end)/2;
            long total = 0;
            for(int r: ranks){
                long cnt = (long)Math.sqrt(mid/ r);
                total += cnt;
            }

            if(total >= cars){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }
}