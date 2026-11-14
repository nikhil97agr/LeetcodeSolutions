package reverse_words_in_a_string_iii_557;

class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        for(String str : s.split(" ")){
            StringBuilder temp = new StringBuilder(str);
            temp.reverse();
            result.append(temp.toString()+" ");
        }

        return result.toString().trim();
    }
}