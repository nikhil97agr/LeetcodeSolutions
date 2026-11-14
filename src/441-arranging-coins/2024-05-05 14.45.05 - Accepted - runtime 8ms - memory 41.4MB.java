class Solution {
    public int arrangeCoins(int n) {
        int cnt = 0;
        int next = 1;
        while(n >= next){
            n-= next;
            next++;
            cnt++;
        }
        return cnt;
    }
}