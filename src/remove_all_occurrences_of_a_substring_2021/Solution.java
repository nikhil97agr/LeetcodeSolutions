package remove_all_occurrences_of_a_substring_2021;

class Solution {
    public String removeOccurrences(String s, String part) {
        String str = "";

        for(int i=0;i<s.length();i++){
            str+= s.charAt(i);
            while(str.endsWith(part)){
                str = str.substring(0, str.length() - part.length());
            }
        }
        return str;
    }
}