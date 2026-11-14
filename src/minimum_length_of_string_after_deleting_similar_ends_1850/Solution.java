package minimum_length_of_string_after_deleting_similar_ends_1850;

class Solution {
    public int minimumLength(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start < end && s.charAt(start) == s.charAt(end)){
            char c = s.charAt(start);
            while(start < end && s.charAt(start) ==c) start++;
            while(end >= start && s.charAt(end) == c) end--;
        }

        if(end < start) return 0;
        return end - start+1;
    }
}