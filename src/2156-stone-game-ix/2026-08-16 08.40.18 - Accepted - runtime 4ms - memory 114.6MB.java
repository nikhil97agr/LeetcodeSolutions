class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt[] = new int[3];
        int n = stones.length;
        for(int x : stones){
            cnt[x%3]++;
        }

        if(cnt[0] == n) return false;

        if(cnt[0] %2==0){
            return cnt[1] > 0 && cnt[2] > 0;
        }

        return Math.abs(cnt[1] - cnt[2] ) > 2;
    }
}