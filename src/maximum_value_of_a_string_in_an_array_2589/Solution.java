package maximum_value_of_a_string_in_an_array_2589;

class Solution {
    public int maximumValue(String[] strs) {
        int ans = 0;

        for(String s : strs){
            boolean word = false;

            for(char c : s.toCharArray()){
                if(Character.isLetter(c)){
                    word = true;
                    break;
                }
            }

            if(word){
                ans = Math.max(ans, s.length());
            }else{
                ans = Math.max(ans, Integer.parseInt(s));
            }
        }
        return ans;
    }
}