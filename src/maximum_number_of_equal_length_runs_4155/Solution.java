package maximum_number_of_equal_length_runs_4155;

class Solution {
    public int maxSameLengthRuns(String s) {
        char prev = s.charAt(0);
        int cnt = 0;
        int c[] = new int[s.length()+1];
        for(char ch : s.toCharArray()){
            if(ch == prev){
                cnt++;
            }else{
                c[cnt]++;
                cnt = 1;
                prev =ch;
            }
        }
        c[cnt]++;

        int ans = 0;

        for(int x : c){
            ans = Math.max(ans, x);
        }

        return ans;
    }
}