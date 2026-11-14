package find_nth_smallest_integer_with_k_one_bits_4189;

class Solution {
    public long nthSmallest(long n, int k) {
        long comb[][] = new long[51][51];
        for(int i=0;i<=50;i++){
            comb[i][0] = 1;
            for(int j=1;j<=i;j++){
                comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
            }
        }

        long start =0;
        long end = (1l << 50);

        long ans = end;
        while(start <= end){
            long mid = start + (end- start)/2;

            long total = count(comb, mid, k);
            if(total >= n){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;

        
        
    }

    private long count(long comb[][], long n, int k){
        long ans = 0;
        int set = 0;

        for(int i=50;i>=0;i--){
            if(((n>>i) & 1l) == 1l){
                int req = k - set;
                if(req >=0 && req <= i){
                    ans += comb[i][req];
                }
                set++;
            }
        }

        if(set == k) ans++;

        return ans;
    }
}