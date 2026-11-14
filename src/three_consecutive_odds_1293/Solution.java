package three_consecutive_odds_1293;

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n-2;i++){
            if(odd(arr[i]) && odd(arr[i+1]) && odd(arr[i+2]))
            return true;
        }
        return false;
    }

    private boolean odd(int x){
        return x%2==1;
    }
}