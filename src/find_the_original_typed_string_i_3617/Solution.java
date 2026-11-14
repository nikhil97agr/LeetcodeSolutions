package find_the_original_typed_string_i_3617;

class Solution {
    public int possibleStringCount(String word) {
        char prev = word.charAt(0);
        int ans = 0;
        for(char c : word.toCharArray()){
            if(c == prev){
                ans++;
            }else{
 
                prev = c;
            }
        }

        return ans;
    }
}