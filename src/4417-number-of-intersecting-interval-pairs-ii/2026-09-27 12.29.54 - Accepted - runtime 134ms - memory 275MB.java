class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        long ans = 0;
        int n = intervals.length;
        int cnt = 0;
        int transform[][] = new int[2 * n][2];
        int i = 0;
        for(int x[] : intervals){
            transform[i] = new int[] {x[0], 1};
            transform[i+1] = new int[]{x[1], -1};
            i += 2;
        }

        Arrays.sort(transform, (a,b) ->{
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        for(var x : transform){
            if(x[1] == 1){
                cnt++;
            }else{
                cnt--;
                ans += cnt;
            }
        }

        return ans;
    }
}