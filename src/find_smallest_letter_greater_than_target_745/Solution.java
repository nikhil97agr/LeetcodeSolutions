package find_smallest_letter_greater_than_target_745;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char c : letters){
            if(c>target) return c;
        }

        return letters[0];
    }
}