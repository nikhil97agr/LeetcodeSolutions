package check_if_string_is_a_prefix_of_array_2093;

class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String res = "";
        for(String st : words){
            res += st;
            if(res.equals(s)) return true;
        }
        return false;
    }
}