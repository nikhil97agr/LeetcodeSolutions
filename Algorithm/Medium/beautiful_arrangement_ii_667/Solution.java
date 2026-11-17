package beautiful_arrangement_ii_667;

class Solution {
    public int[] constructArray(int n, int k) {
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = i+1;
        }

        int ind = n-k;
        int start = n;
        int end = n - k+1;

        while(ind < n){
            ans[ind] = start--;
            ind+=2;
        }

        ind = n-k+1;

        while(ind < n){
            ans[ind] = end++;
            ind+=2;
        }

        return ans;

    }
}


