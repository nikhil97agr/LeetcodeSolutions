package redistribute_characters_to_make_all_strings_equal_2025;

class Solution {
    public boolean makeEqual(String[] words) {
        int count[] = new int[26];
        for(String word : words){
            for(char ch  :word.toCharArray()){
                count[ch-'a']++;
            }
        }
        int n = words.length;
        for(int x : count){
            if(x%n!=0) return false;
        }
        return true;
    }
}