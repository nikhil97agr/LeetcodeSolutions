class Solution {
    public long[] findPrefixScore(int[] arr) {
        int n = arr.length;
        long ans[] = new long[n];
        int max = arr[0];
        ans[0] = arr[0]*2;
        for(int i=1;i<n;i++){
            max = Math.max(max, arr[i]);
            ans[i] = arr[i] + ans[i-1] + max;
        }
        
        return ans;
    }
}