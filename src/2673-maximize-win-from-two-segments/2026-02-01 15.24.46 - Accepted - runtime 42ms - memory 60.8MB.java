class Solution {
    public int maximizeWin(int[] arr, int k) {
        int n = arr.length;
        int cnt[] = new int[n];
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            long start = arr[i];
            long end = start  + k;
            int ind= binarySearch(arr, i, end);
            int c = ind - i + 1;
            cnt[i] = c;
            if(i!= n-1){
                cnt[i] = Math.max(cnt[i], cnt[i+1]);
            }
        }

        for(int i=0;i<n;i++){
            long end = arr[i] + k;
            int ind = binarySearch(arr, i, end);
            int c1 = ind -i + 1;
            if(ind +1 < n){
                ans = Math.max(ans, c1 + cnt[ind+1]);
            }else{
                ans = Math.max(ans, c1);
            }
        }

        return ans;

    }

    private int binarySearch(int arr[], int ind, long val){
        int ans = ind;
        int start = ind;
        int end = arr.length -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] <= val){
                ans=mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }
}