class Solution {
    public long singleDivisorTriplet(int[] nums) {
        long ans = 0;
        int cnt[] = new int[101];
        for(int x : nums){
            cnt[x]++;
        }

        for(int i=1;i<=100;i++){
            for(int j=i;j<=100 && cnt[i] > 0;j++){
                for(int k=j;k<=100 && cnt[j] > 0;k++){
                    int sum = i+j+k;
                    if(sum%i!=0 && sum%j!=0 && sum%k!=0) continue;
                    int c = 0;
                    if(sum%i==0) c++;
                    if(sum%j==0) c++;
                    if(sum%k==0) c++;
                    long total = 1l * cnt[i]*cnt[j]*cnt[k];
                    if(total ==0 || c != 1) continue;
                    if(i ==j || j == k){
                        total = (total *(cnt[j] - 1))/ (2 * cnt[j]);
                    }
                    ans += 6l * total;

                }
            }
        }

        return ans;
    }
}