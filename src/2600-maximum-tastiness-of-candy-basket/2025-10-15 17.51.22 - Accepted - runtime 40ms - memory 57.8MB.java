class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int start = 0;
        int end = price[n-1] - price[0];

        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            int cnt= 1;

            int prev = price[0];

            for(int i=1;i<n;i++){
                if(price[i] - prev >= mid){
                    prev= price[i];
                    cnt++;
                }
            }
            if(cnt >= k){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }
}