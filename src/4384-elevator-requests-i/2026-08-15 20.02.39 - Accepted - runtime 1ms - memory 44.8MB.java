class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int curr = 0;
        int ans = 0;
        for(int x : requests){
            ans += Math.abs(curr - x);
            curr = x;
        }

        return ans;
    }
}