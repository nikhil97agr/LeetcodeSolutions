package find_the_least_frequent_digit_3994;

class Solution {
    public int getLeastFrequentDigit(int n) {
        int cnt[] = new int[10];
        while(n > 0){
            cnt[n%10]++;
            n/=10;
        }

        int ans = -1;
        int c = 31;

        for(int i=0;i<10;i++){
            if(cnt[i] < c && cnt[i] !=0){
                c = cnt[i];
                ans = i;
            }
        }
        return ans;
    }
}