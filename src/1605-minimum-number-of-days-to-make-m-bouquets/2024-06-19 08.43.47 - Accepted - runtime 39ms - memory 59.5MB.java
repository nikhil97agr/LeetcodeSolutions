class Solution {
    public int minDays(int[] arr, int m, int k) {
        int ans = -1;
        int start = Arrays.stream(arr).min().getAsInt();
        int end = Arrays.stream(arr).max().getAsInt();
        while(start <= end){
            int mid = (start + end)/2;
            int total = 0;
            int cnt = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i] <= mid){
                    cnt++;
                }else{
                    cnt = 0;
                }

                if(cnt == k){
                    cnt = 0;
                    total++;
                }
            }
            if(total >= m){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}