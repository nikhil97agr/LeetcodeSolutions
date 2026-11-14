package maximum_repeating_substring_1764;

class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
       String find = "";
        while(sequence.contains(find))find+=word;
        return (find.length()-word.length())/word.length();
    }
}