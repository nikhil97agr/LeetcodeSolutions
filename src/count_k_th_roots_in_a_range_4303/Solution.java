package count_k_th_roots_in_a_range_4303;

class Solution {
    public int countKthRoots(int l, int r, int k) {
        if(k == 1){
            return r- l + 1;
        }

        int ans = 0;
        int i = 0;
        while(true){
            long pow = pow(i, k);
            if(pow > r ) break;
            if(pow >=l && pow <= r) ans++;
            i++;
        }

        return ans;
    }

    private long pow(long a, int b){
        long ans = 1;
        while(b > 0){
            if(b%2==1){
                ans *= a;
            }

            a = a * a;
            b>>=1;
        }
        return ans;
    }
}