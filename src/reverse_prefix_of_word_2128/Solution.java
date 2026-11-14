package reverse_prefix_of_word_2128;

class Solution {
    public String reversePrefix(String word, char ch) {
        int ind = word.indexOf(ch);
        if(ind == -1) return word;

        StringBuilder sb = new StringBuilder(word.substring(0, ind+1));
        sb.reverse();
        return sb.toString() + word.substring(ind+1);
    }
}