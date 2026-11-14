class Solution {
    public int mostFrequentEven(int[] nums) {
        int cnt[] = new int[100001];

        for(int x : nums){
            cnt[x]++;
        }

        int ans = -1;
        int d = -1;

        for(int i=0;i<=100000;i+=2)
        {
            if(cnt[i] !=0){
                if(cnt[i] > d){
                    d = cnt[i];
                    ans = i;
                }
            }
        }

        return ans;
    }
}