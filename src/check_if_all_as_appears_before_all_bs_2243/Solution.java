package check_if_all_as_appears_before_all_bs_2243;

class Solution {
    public boolean checkString(String s) {
        boolean b = false;
        for(char c : s.toCharArray()){
            if(c=='b') b =true;

            if(c=='a'){
                if(b) return false;
            }
        }

        return true;
    }
}