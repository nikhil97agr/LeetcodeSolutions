class Solution {
    public int earliestTime(int[][] tasks) {
        int ans = Integer.MAX_VALUE;

        for(int t[] : tasks){
            int end = t[0] + t[1];

            ans = Math.min(ans, end);
        }

        return ans;
    }
}