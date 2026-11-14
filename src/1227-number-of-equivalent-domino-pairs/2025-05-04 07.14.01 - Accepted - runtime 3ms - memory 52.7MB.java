class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans  = 0;
        int cnt[] = new int[100];

        for(int d[] : dominoes){
            int a = d[0];
            int b = d[1];

            int num = a < b ? a*10 + b : b*10 + a;

            ans += cnt[num];
            cnt[num]++;
        }
        return ans;
    }
}