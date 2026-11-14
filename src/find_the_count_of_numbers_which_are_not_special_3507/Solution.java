package find_the_count_of_numbers_which_are_not_special_3507;

class Solution {
    public int nonSpecialCount(int l, int r) {
        int ans = 0;
        for(int i=2;i*i <=r ;i++){
            if(isPrime(i)){
                if(i*i>=l){
                    ans++;
                }
            }
        }
        return (r-l+1) - ans;
    }

    private boolean isPrime(int i){
        if(i==2 || i==3 )return true;
        if(i%2==0) return false;

        for(int j=3;j<=Math.sqrt(i);j+=2){
            if(i%j==0) return false;
        }
        return true;
    }
}