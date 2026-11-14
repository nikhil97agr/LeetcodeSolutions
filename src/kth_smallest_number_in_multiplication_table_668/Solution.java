package kth_smallest_number_in_multiplication_table_668;

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int ans = 0;
        int start = 1;
        int end = m*n;
        while(start <= end){
            int mid = (start + end)/2;
            if(count(mid, m, n )>=k){
                end = mid - 1;
                ans = mid;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    private int count(int val, int m, int n){
        int total =0;
        for(int i=1;i<=m;i++){
            total += Math.min(n, val/i);
        }

        return total;
    }
}