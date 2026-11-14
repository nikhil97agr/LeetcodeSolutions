package maximum_number_of_balloons_1297;

class Solution {
    public int maxNumberOfBalloons(String text) {
        int cnt[] = new int[26];
        for(char c : text.toCharArray()){
            cnt[c-'a']++;
        }

        int ans = text.length();
        char c[] = new char[]{'b', 'a', 'l', 'o', 'n'};
        for(char ch : c){
            if(ch == 'l' || ch == 'o'){
                ans = Math.min(ans, cnt[ch-'a']/2);
            }else{
                ans = Math.min(ans, cnt[ch-'a']);
            }
        }

        return ans;
    }
}