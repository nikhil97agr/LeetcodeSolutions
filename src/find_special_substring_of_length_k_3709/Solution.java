package find_special_substring_of_length_k_3709;

class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        char prev = s.charAt(0);
        int cnt = 0;

        for(char c : s.toCharArray()){
            if(c== prev){
                cnt++;
            }else{
                if(cnt == k) return true;
                cnt = 1;
                prev = c;
            }
        }

        return cnt == k;
    }
}