package append_characters_to_string_to_make_subsequence_2572;

class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                j++;
            }
            i++;
        }
        return t.length() - j;
    }
}