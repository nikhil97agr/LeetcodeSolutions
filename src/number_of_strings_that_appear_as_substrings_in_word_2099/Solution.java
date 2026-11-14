package number_of_strings_that_appear_as_substrings_in_word_2099;

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for(String s : patterns){
            if(word.contains(s)){
                ans++;
            }
        }

        return ans;
    }
}