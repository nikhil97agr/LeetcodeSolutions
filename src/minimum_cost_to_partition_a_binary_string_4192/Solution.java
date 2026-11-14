package minimum_cost_to_partition_a_binary_string_4192;

class Solution {
    public long minCost(String s, int encCost, int flatCost) {
        char ch[] = s.toCharArray();
        int n =s.length();
        long pre[] = new long[n+1];
        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1] + (ch[i-1] - '0');
        }

        return solve(0, n-1, ch, encCost, flatCost, pre);
    }

    private long solve(int start, int end, char ch[], int  encCost, int flatCost, long pre[]){
        if(start > end){
             return Long.MAX_VALUE;
        }

        long cnt = pre[end+1] - pre[start];

        long c1 = flatCost;
        int len = end - start + 1;
        if(cnt > 0){
            c1 = cnt * len * encCost;
        }

        long left = (long)1e18;
        long right = (long)1e18;
        if(len %2==0){
            int mid = (start+end)/2;
            left = solve(start, mid, ch, encCost, flatCost, pre);
            right = solve(mid+1, end, ch, encCost, flatCost, pre);
        }
        
        return Math.min(c1, left + right);
    }
}