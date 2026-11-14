class Solution {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int ans = -1;
        while(start <= end){
            int mid = (end - start)/2 + start;
            long temp = 1l*mid*mid;
            if(temp >x){
                end = mid-1;
            }else{
                ans = mid;
                start = mid+1;
            }
        }
        
        return ans;
    }
}