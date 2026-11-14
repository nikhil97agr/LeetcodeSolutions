class Solution {
    public int magicalString(int n) {
        if(n<=3) return 1;
        int cnt[] = new int[n];
        int ans =1;
        int curr = 1;
        cnt[0] = 1;
        cnt[1] = cnt[2] = 2;
        int i=2;
        int j = 3;
        while( j < n){
            int c = cnt[i];
            for(int k=0;k<c && j < n;k++,j++){
                cnt[j] = curr;
                if(curr == 1){
                    ans++;
                }
            }

            curr = curr == 1 ? 2 : 1;
            i++;
        }

        return ans;
    }
}