package check_if_one_string_swap_can_make_strings_equal_1915;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int differ = 0;
        int cnt[] = new int[26];
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                differ++;
            }
            cnt[s1.charAt(i)-'a']++;
            cnt[s2.charAt(i)-'a']--;
        }
        for(int i : cnt){
            if(i!=0){
                return false;
            }
        }
        if(differ==0 || differ==2){
            return true;
        }
        return false;
        
    }
}