class Solution {
    public int[] reverseSubarrays(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n];
        int len = n/k;
        for(int i=0;i<n;i+=len){
            reverse(nums, ans, i, i + len-1);
        }


        return ans;
    }

    private void reverse(int a[], int b[], int start, int end){
        int j = start;
        while(end >= start){
            b[j++] = a[end--];
        }
    }
}