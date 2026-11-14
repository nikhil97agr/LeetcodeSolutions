package minimum_time_to_revert_word_to_initial_state_i_3297;

class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int cnt = 0;
        int ind = 0;
        int n = word.length();
        while(true){
            if(ind + k <= n){
                String s = word.substring(ind, ind+k);
                cnt++;
                String left = word.substring(ind+k, n);
                int len = left.length();
                String pref = word.substring(0, len);
                if(left.equals(pref)){
                    return cnt;
                }
                ind += k;
            }else{
                cnt++;
                return cnt;
            }
        }
        
    }
}