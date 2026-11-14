class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1) return 0;

        int digit = 0;
        int low = 1;
        int high = 1<<(n-1);
        while(n>0){
            int mid = low + (high - low)/2;

            if(k<=mid){
                high = mid;

            }else{
                low = mid+1;
                digit ^=1;
            }
            n--;
        }
        return digit;
    }
}