class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int ans = 0;

        int n = arr.length;
        int inc = 1;
        int dec =1;
        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1]){
                inc++;
            }else{
                ans = Math.max(ans, inc);
                inc = 1;
            }

            if(arr[i] < arr[i-1]){
                dec++;
            }else{
                ans = Math.max(ans, dec);
                dec = 1;
            }

        }
        ans = Math.max(ans, inc);
        ans = Math.max(ans, dec);
        return ans;
    }
}