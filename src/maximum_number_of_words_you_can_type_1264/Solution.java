package maximum_number_of_words_you_can_type_1264;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        for(String s : text.split(" ")){
            boolean possible = true;

            for(char c : s.toCharArray()){
                if(contains(brokenLetters, c)){
                   possible = false;
                   break; 
                }
            }

            if(possible) ans++;
        }

        return ans;
    }

    private boolean contains(String s, char c){
        for(char ch : s.toCharArray()){
            if(ch ==c) return true;
        }
        return false;
    }
}