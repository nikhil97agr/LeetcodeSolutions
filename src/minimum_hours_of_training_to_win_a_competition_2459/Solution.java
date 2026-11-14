package minimum_hours_of_training_to_win_a_competition_2459;

class Solution {
    public int minNumberOfHours(int en, int ex, int[] a, int[] b) {
        int ans = 0;
        int n = a.length;

        for(int i=0;i<n;i++){
            if(en > a[i]){
                en-= a[i];
            }else{
                int diff = a[i] - en + 1;
                ans += diff;
                en = 1;
            }

            if(ex > b[i]){
                ex+=b[i];
            }else{
                int diff= b[i] - ex + 1;
                ans += diff;
                ex = b[i] + 1 + b[i];
            }
        }

        return ans;
    }
}