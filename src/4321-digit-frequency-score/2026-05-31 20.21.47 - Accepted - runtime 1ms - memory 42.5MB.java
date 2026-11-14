class Solution {
    public int digitFrequencyScore(int n) {
        int ans = 0;
        int cnt[] = new int[10];
        while(n > 0){
            int dig = n%10;
            n/=10;
            cnt[dig]++;
        }

        for(int i=0;i<10;i++){
            ans += i * cnt[i];
        }

        return ans;
    }
}