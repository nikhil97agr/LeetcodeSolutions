package count_numbers_with_unique_digits_357;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1;

        for(int i=1;i<=n;i++){
            ans += fact(i);
        }

        return ans;
    }

    private int fact(int x){
        if(x==1) return 9;
        int ans = 9;
        for(int j=0;j<x-1;j++){
            ans *= (9-j);
        }

        return ans;
    }
}