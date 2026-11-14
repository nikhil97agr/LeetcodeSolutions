package concatenate_non_zero_digits_and_multiply_by_sum_ii_4136;

class Solution {
    long mod = (long)1e9 + 7;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        char ch[] = s.toCharArray();
        int preSum[] = new int[n];
        int preNum[] = new int[n];
        int preCnt[] = new int[n];
        int pow[] = new int[n];
        for(int i=0;i<n;i++){
            int dig = ch[i] - '0';
            if(i==0){
                preSum[i] = dig;
                if(dig !=0){
                    preNum[i] = dig;
                    preCnt[i] = 1;
                }else{
                }
            }else{
                preSum[i] = preSum[i-1] + dig;
                if(dig !=0){
                    preNum[i] = sum(10l * preNum[i-1], dig);
                    preCnt[i] = preCnt[i-1] + 1;

                }else{
                    preNum[i] = preNum[i-1];
                    preCnt[i] = preCnt[i-1];
                }
            }
            pow[i] = pow(10, preCnt[i]);
        }
        int q = queries.length;
        int ans[] = new int[q];

        for(int i=0;i<q;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int sum = preSum[r] - (l==0 ? 0 : preSum[l-1]);
            int cnt = preCnt[r] - (l==0 ? 0 : preCnt[l-1]);
            int x = sum(preNum[r] ,- prod((l==0 ? 0 : preNum[l-1]) , pow(10, cnt)));

            ans[i] = prod(sum, x);
        }



        return ans;

    }

    private int pow(int a, int b){
        if(a== 1 || b==0) return 1;
        if(b==1) return a;
        int p = pow(a, b/2);
        p = prod(p,p);
        if(b%2==1){
            p = prod(p, a);
        }

        return p;
    }



    private int prod(long a, long b){
        long p = a * b;

        return (int)(p%mod);
    }

    private int sum(long a, long b){
        long s = a + b + mod;

        return (int)(s%mod);
    }
}