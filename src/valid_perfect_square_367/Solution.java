package valid_perfect_square_367;

class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1 ) return true;

       int start = 1;
       int end = num;
       while(start <= end){
           int mid = start + (end-start)/2;

           long x = 1L*mid*mid;
           if(x == 1L*num) return true;

            if(x < 1L*num){
                start = mid+1;
            }else{
                end = mid-1;
            }
       }

       return false;
    }
}