class Solution {
    public String getPermutation(int n, int k) {
        boolean vis[] =new boolean[n+1];

        StringBuilder res = new StringBuilder();
        int ind = 1;
        while(res.length() != n){
            for(int i=1;i<=9;i++){
                if(!vis[i]){
                    int cnt = getCnt(n-ind);
                    if(cnt < k){
                        k -= cnt;
                    }else{
                        res.append(i);
                        vis[i] = true;
                        ind++;
                        break;
                    }
                }
            }
        }

        return res.toString();
    }

    private int getCnt(int n){
        int ans = 1;

        for(int i=1;i<=n;i++){
            ans *=i ;
        }

        return ans;
    }
}