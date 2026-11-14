class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        for(int bit = 62;bit>=1;bit--){
            if((1l << bit) < num){
                long res = search(num, bit);
                if(res != -1) return Long.toString(res);
            }
        }



        return Long.toString(num-1);
    }

    private long search(long n, int bit){
        long left = 1;
        long right = (long)(Math.pow(n, 1d/bit) + 1);

        while(left <= right){
            long mid = left + (right - left)/2;
            long total = 1;
            long next = 1;
            for(int i=1;i<=bit && total <= n ;i++){
                next *=mid;
                total += next;
            }

            if(total == n) return mid;

            if(total > n){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return -1;
    }
}