package check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence_1566;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String w[] = sentence.split(" ");

        for(int i=0;i<w.length;i++){
            if(w[i].startsWith(searchWord)) return i+1;
        }
        return -1;
    }
}