package minimum_time_to_visit_all_houses_3880;

class Solution {
    public long minTotalTime(int[] forward, int[] backward, int[] queries) {
        int n = forward.length;
        long f[]= new long[n+1];
        long b[] = new long[n+1];

        for(int i=1;i<=n;i++){
            f[i] = f[i-1] + forward[i-1];
        }

        for(int i=n-1;i>=0;i--){
            b[i] =b[i+1] + backward[i];
        }

        long ans = 0;
        int start = 0;

        for(int end : queries){
            long a1;
            long a2;

            if(start < end){
                a1 = f[end] - f[start];

                a2 = b[0] - b[start+1] + b[end+1];
            }else{
                a2 = b[end+1] - b[start+1];

                 a1 = f[n] - f[start] + f[end];
            }

            start = end;
            ans = ans + Math.min(a1, a2);
        }

        return ans;
    }
}