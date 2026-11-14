package minimum_number_of_steps_to_make_two_strings_anagram_ii_2293;

class Solution {
    public int minSteps(String s, String t) {
        int count[] = new int[26];
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        for(char c  : t.toCharArray()){
            count[c-'a']--;
        }
        
        int total = 0;
        for(int x : count){
            total += Math.abs(x);
        }
        return total;
    }
}