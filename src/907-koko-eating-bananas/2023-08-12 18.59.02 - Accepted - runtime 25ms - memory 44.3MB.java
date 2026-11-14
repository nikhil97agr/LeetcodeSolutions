class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int x : piles){
            right = Math.max(x, right);
        }

        if(piles.length==h){
            return right;
        }

        while(left < right){
            int mid = (left+right)/2;
            long total = 0;
            for(int x : piles){
                total += (long)Math.ceil((1d*x)/(1d*mid));
            }

            if(total <= 1l*h){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;
        
    }
}