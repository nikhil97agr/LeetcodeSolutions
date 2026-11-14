package count_prefixes_of_a_given_string_2341;

class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for(String str : words){
            if(s.startsWith(str)){
                ans++;
            }
        }

        return ans;
    }
}