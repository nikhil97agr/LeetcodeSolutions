package the_kth_factor_of_n_1585;

class Solution {
    public int kthFactor(int n, int k) {
        int count = getCnt(n);

        if(count < k ) return -1;

        int start = 1;
        int end = count;

        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(start == k) return i;
                if(end == k) return n/i;
                start++;
                end--;
            }
        }

        return -1;
    }

    private int getCnt(int n){
        int ans = 0;

        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i ==i){
                    ans++;
                }else{
                    ans+=2;
                }
            }
        }
        return ans;
    }
}