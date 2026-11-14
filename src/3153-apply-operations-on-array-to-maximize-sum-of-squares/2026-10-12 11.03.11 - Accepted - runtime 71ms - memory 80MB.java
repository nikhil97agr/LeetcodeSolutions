class Solution {
    long mod = (long)1e9 + 7;
    public int maxSum(List<Integer> nums, int k) {
        int ans = 0;

        int cnt[] = new int [32];
        for(int x : nums){
            for(int i=0;i<32;i++){
                if((x & (1<<i))!=0){
                    cnt[i]++;
                }
            }
        }

        for(int i=0;i<k;i++){
            int num = 0;
            for(int j=0;j<32;j++){
                if(cnt[j] > 0){
                    num |= 1<<j;
                    cnt[j]--;
                }
            }
            ans = add(ans, prod(num, num));
        }


        return ans;
    }

    private int add(long a, long b){
        return (int)((a+b)%mod);
    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }
}