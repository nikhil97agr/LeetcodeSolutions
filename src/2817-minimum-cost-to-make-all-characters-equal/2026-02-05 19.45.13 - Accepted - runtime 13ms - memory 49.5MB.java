class Solution {
    public long minimumCost(String s) {
        int n = s.length();
        if(n==1) return 0;
        char ch[] = s.toCharArray();
        long pre[] = new long[n];
        long suff[] = new long[n];
        for(int i=1;i<n;i++){
            if(ch[i] == ch[i-1]){
                pre[i] = pre[i-1];
            }else{
                pre[i] += pre[i-1] +(i);
            }
        }

        for(int i=n-2;i>=0;i--){
            if(ch[i] == ch[i+1]){
                suff[i] = suff[i+1];
            }else{
                suff[i]  =suff[i+1] + (n - (i+1));
            }
        }

        long ans = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(ans, pre[i] + suff[i]);
        }

        return ans;
    }
}