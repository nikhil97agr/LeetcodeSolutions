class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int ans = 0;
        for(int i=0;i<jobs.length;i++){
            int t = jobs[i];
            int d = workers[i];

            ans = Math.max(ans, (t +d - 1)/d);
        }

        return ans;
    }
}