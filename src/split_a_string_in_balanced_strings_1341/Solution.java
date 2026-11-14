package split_a_string_in_balanced_strings_1341;

class Solution {
    public int balancedStringSplit(String s) {
        int cnt = 0;
        int l = 0;
        int r = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L') l++;
            else r++;

            if(l==r){
                cnt++;
                l=0;
                r=0;
            }
        }
        return cnt;
    }
}