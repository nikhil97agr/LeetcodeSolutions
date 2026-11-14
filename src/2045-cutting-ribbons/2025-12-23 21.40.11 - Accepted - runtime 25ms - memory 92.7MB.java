class Solution {
    public int maxLength(int[] ribbons, int k) {
        int min = 1;
        int max = 100000;
        int ans = 0;
        while(min <= max){
            int mid = min + ( max - min ) /2;

            long cnt = 0;
            for(int x : ribbons){
                cnt += (x / mid);
            }

            if(cnt >= k){
                ans = mid;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        return ans;
    }
}