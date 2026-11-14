package next_greater_numerically_balanced_number_2174;

class Solution {
    public int nextBeautifulNumber(int n) {
        int start = n + 1;
        while(true){
            if(balanced(start)) return start;
            start++;
        }
    }

    private boolean balanced(int n){
        int cnt[] = new int[10];
        while(n > 0){
            int dig = n%10;
            cnt[dig]++;
            n/=10;
        }

        for(int i=0;i<10;i++){
            if(cnt[i] > 0 && cnt[i] !=i) return false;
        }

        return true;
    }
}