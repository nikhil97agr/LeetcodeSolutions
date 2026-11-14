package minimum_suffix_flips_1652;

class Solution {
    public int minFlips(String target) {
        int flip = 0;
        for(char c : target.toCharArray()){

            if(c== '0' && (flip&1) !=0){
                flip++;
            }else if(c=='1' && (flip&1)==0){
                flip++;
            }
        }
        return flip;
    }
}