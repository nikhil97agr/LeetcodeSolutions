package guess_number_higher_or_lower_374;

// Forward declaration of guess API.
class GuessGame {
    // @param  num   your guess
    // @return       -1 if num is higher than the picked number
    //                1 if num is lower than the picked number
    //                otherwise return 0
    int guess(int num) {
        // The real implementation is provided by the judge.
        throw new UnsupportedOperationException();
    }
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = (end - start)/2 + start;
            
            int ans = guess(mid);
            if(ans == 1){
                start = mid+1;
            }else if(ans == -1){
                end = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}