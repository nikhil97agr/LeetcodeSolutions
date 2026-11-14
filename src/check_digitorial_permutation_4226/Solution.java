package check_digitorial_permutation_4226;

class Solution {
    public boolean isDigitorialPermutation(int n) {
        int cnt[] = getCnt(n);
        int ans = 0;
        for(int i=0;i<10;i++){
            ans += cnt[i] * fact(i);
        }
        int c2[] = getCnt(ans);

        for(int i=0;i<10;i++){
            if(c2[i] != cnt[i]) return false;
        }
        return true;
    }

    private int fact(int x){
        int ans = 1;
        for(int i=1;i<=x;i++){
            ans *= i;
        }
        return ans;
    }

    private int[] getCnt(int n){
    int cnt[] = new int[10];
    while( n > 0){
        int dig = n%10;
        cnt[dig]++;
        n/=10;
    }
    return cnt;
}
}



/**
    1 - 1
    2 - 1 * 2
    3 - 1 * 2 * 3
    4 = 1 * 2 * 3 * 4


 */