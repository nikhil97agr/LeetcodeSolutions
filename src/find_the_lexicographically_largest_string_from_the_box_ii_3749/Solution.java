package find_the_lexicographically_largest_string_from_the_box_ii_3749;

class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        var n = word.length();
        int maxLen = n - (numFriends - 1);
        int start = 0;
        int end = 1;
        int length = 0;

        while(end + length < n){
            int diff = word.charAt(start + length) - word.charAt(end + length);

            if(diff ==0){
                length++;
            }else if(diff > 0){
                end += length + 1;
                length = 0;
            }else{
                start = Math.max(start + length +1, end);
                end = start + 1;
                length = 0;
            }
        }

        return word.substring(start, Math.min(n, start + maxLen));

    }
}