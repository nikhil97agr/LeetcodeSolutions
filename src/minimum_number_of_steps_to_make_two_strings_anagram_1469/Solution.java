package minimum_number_of_steps_to_make_two_strings_anagram_1469;

class Solution {
    public int minSteps(String s, String t) {
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }
        for(char c : t.toCharArray()){
            cnt[c-'a']--;
        }

        int ans = 0;
        for(int x : cnt) ans += Math.abs(x);
        return ans/2;
    }
}