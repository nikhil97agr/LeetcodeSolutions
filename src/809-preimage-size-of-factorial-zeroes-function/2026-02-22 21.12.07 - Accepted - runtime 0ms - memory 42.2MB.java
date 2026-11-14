class Solution {
    public int preimageSizeFZF(int k) {
        long start = 0;
        long end =(long)Math.pow(10, 10);
        while(start <= end){
            long mid = start + (end - start)/2;

            long v = mid;
            long cnt = 0;
            while(v > 0){
                cnt += v/5;
                v/=5;
            }

            if(cnt == k) return 5;
            if(cnt > k) end = mid - 1;
            else start = mid + 1;
        }

        return 0;
    }
}