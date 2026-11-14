class Solution {
    public int countCommas(int n) {
        int ans = 0;
        for(int i=1000;i<=n;i++){
            int len = Integer.toString(i).length();
            ans += len /3;
            if(len%3==0){
                ans--;
            }
        }
        return ans;
    }

    
}