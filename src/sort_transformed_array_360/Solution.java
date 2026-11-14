package sort_transformed_array_360;

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int ans[] = new int[n];
        int cnt[] = new int[9000000];
        int m = cnt.length;
        for(int i=0;i<n;i++){
            int x = nums[i];
            int val= a*x*x + b*x + c;
            cnt[1000000 + val]++;
        }
        int ind=0;

        for(int i=0;i<m;i++){
            while(cnt[i]-- > 0){
                ans[ind++] = i - 1000000;
            }
        }

        return ans;
    }
}