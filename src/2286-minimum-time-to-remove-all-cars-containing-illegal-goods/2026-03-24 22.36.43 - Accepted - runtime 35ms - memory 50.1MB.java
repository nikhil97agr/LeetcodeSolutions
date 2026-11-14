class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        char ch[] = s.toCharArray();
        int suff[] = new int[n+1];

        for(int i=n-1;i>=0;i--){
            if(ch[i] == '1'){
                suff[i] = Math.min(suff[i+1] + 2 , n - i);
            }else{
                suff[i] = Math.min(suff[i+1], n - i);
            }
        }

        int ans = n;
        int pre = 0;
        for(int i=0;i<n;i++){
            if(ch[i] == '1'){
                pre = Math.min(pre + 2, i + 1);
            }

            ans= Math.min(ans, pre + suff[i+1]);
        }

        return ans;

    }
}