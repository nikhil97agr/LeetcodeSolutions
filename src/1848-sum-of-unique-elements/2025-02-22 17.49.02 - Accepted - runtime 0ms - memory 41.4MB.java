class Solution {
    public int sumOfUnique(int[] nums) {
        int cnt[] = new int[101];
        for(int x : nums) cnt[x]++;
        int ans = 0;
        for(int i=0;i<101;i++){
            if(cnt[i] == 1) ans+=i;
        }
        return ans;
    }
}