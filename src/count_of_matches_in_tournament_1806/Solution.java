package count_of_matches_in_tournament_1806;

class Solution {
    public int numberOfMatches(int n) {
        int count = 0;
        while(n>1){
            if((n&1)==1){
                count += n/2;
                n = (n+1)/2;
            }else{
                count += n/2;
                n/=2;
            }
        }
        return count;
    }
}