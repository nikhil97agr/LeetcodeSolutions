class Solution {
    public long minimumPerimeter(long neededApples) {
        long ans = 0;
        long start = 1;
        long end = 1000000;

        while(start <= end){
            long mid = (start + end)/2;
            long apples = mid*(mid+1)*(2*mid+1)*2;

            if(apples >= neededApples){
                ans = 8l * mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }

        return ans;
    }

}