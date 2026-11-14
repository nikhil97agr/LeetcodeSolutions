class Solution {
    public int maximumCandies(int[] candies, long k) {
        long start = 1;
        long end = 0;
        for(int c : candies){
            end += c;
        }
        while(start <= end){
            long mid = (start+end)/2;
            long cnt = 0;
            for(long c : candies){
                cnt += c/mid;
            }

            if(cnt >=k){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return (int)end;
    }
}