class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;
        for(int x : quantities){
            right = Math.max(right, x);
        }

        while(left < right){
            int mid = (left+right)/2;
            int total = 0;
            for(int x : quantities){
                total += (x+mid-1)/mid;
            }

            if(total > n){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}