class Solution {
    public int maximumPopulation(int[][] logs) {
        int cnt[] = new int[2051];

        for(int l[] : logs){
            cnt[l[0]]++;
            cnt[l[1]]--;
        }
        int c = 0;
        int ans = 0;
        int res = 0;
        for(int i=0;i<=2050;i++){
            c += cnt[i];
            if(c > ans){
                ans =c;
                res = i;
            }
        }

        return res;
    }
}