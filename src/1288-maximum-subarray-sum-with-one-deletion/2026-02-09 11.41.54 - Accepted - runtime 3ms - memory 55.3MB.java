class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        if(n==1) return arr[0];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            pre[i] = sum;
            sum = Math.max(sum, 0);
        }
        sum =0;
        for(int i=n-1;i>=0;i--){
            sum += arr[i];
            suff[i] = sum;
            sum = Math.max(sum, 0);
        }

        int ans = suff[0];
        for(int i=0;i<n;i++){
            if(i==0){
                ans= Math.max(ans, suff[i+1]);
            }else if(i==n-1){
                ans = Math.max(ans, pre[i-1]);
            }else{
                ans = Math.max(ans,
                Math.max(pre[i-1], Math.max(suff[i+1], pre[i-1] + suff[i+1])));
            }
        }

        return ans;
    }
}