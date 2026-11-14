package vowels_game_in_a_string_3462;

class Solution {
    public boolean doesAliceWin(String s) {
        int vowel = 0;

        for(char c : s.toCharArray()){
            if(c=='a' || c=='e'|| c=='i' || c=='o' || c=='u') vowel++;
        }

        if(vowel%2==1) return true;

        if(vowel ==0) return false;
        return true;
    }
}