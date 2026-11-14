package valid_word_abbreviation_408;

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int len = 0;
        int i=0;
        int j=0;
        while(i < abbr.length() && j < word.length()){
            boolean prev = false;
            if(Character.isDigit(abbr.charAt(i))){
                if(prev) return false;

                prev = true;
                int dig = 0;
                while(i < abbr.length() && Character.isDigit(abbr.charAt(i))){
                    dig = dig * 10 + (abbr.charAt(i) - '0');
                    i++;
                    if(dig ==0) return false;
                }
                len += dig;
                j+=dig;

            }else {
                if(word.charAt(j) != abbr.charAt(i)) return false;
                prev = false;
                j++;
                len++;
                i++;
            }
        }

        return i == abbr.length() && j == word.length() &&  len == word.length();
    }
}