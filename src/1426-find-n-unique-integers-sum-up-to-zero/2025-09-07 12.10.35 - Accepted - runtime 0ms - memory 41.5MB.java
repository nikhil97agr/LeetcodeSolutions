class Solution {
    public int[] sumZero(int n) {
        int ans[] = new int[n];
        if((n&1)==0){
            int i=1;
            int ind = 0;
            while(ind < n){
                ans[ind] = i;
                ans[ind+1] = -i;
                i++;
                ind+=2;
            }
        }else{
            int i=1;
            int ind = 1;
            while(ind < n){
                ans[ind] = i;
                ans[ind+1] = -i;
                i++;
                ind+=2;
            }
        } 
        return ans;
    }
}