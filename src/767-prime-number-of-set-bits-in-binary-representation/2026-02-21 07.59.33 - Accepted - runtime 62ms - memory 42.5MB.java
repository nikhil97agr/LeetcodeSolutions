class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        boolean prime[] = new boolean[33];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i=2;i<=32;i++){
            if(prime[i]){
                int j = i+i;

                while(j<=32){
                    prime[j] = false;
                    j+=i;
                }
            }
        }
        for(int i=left;i<=right;i++){
            int num = i;
            int cnt = 0;
            while(num > 0){
                int dig = num%2;
                if(dig == 1) cnt++;
                num/=2;
            }

            if(prime[cnt]) ans++;
        }

        return ans;
    }


}