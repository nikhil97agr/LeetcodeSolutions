package reverse_words_in_a_string_151;

class Solution {
    public String reverseWords(String s) {
        String words[] = s.trim().split(" ");
        StringBuilder result = new StringBuilder("");
        int n= words.length;
        for(int i=n-1;i>=0;i--){
            if(words[i].length()!=0){
                result.append(words[i]+" ");
            }
        }

        return String.valueOf(result).trim();
    }
}