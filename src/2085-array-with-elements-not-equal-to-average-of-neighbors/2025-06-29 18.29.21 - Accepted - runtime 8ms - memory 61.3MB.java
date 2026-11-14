class Solution {
    public int[] rearrangeArray(int[] nums) {
        int cnt[] = new int[100001];
        for(int x : nums) cnt[x]++;
        int j=0;
        int n = nums.length;
        int ans[] =new int[n];
    
        for(int i=0;i<n;i+=2){
            while(cnt[j] ==0){
                j++;
            }
            ans[i] = j;
            cnt[j]--;
        }

        for(int i=1;i<n;i+=2){
            while(cnt[j]==0) j++;
            ans[i] = j;
            cnt[j]--;
        }

        return ans;
    }
}