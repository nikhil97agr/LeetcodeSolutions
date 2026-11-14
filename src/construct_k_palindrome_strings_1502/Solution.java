package construct_k_palindrome_strings_1502;

class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }
        int c = 0;
        for(int x : cnt){
            if((x&1)==1) c++;
        }

        return c <= k;
    }


}