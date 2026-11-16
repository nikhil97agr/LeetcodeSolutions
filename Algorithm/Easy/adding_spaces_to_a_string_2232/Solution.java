package adding_spaces_to_a_string_2232;

class Solution {
    public String addSpaces(String s, int[] spaces) {
        int ind=0;
        StringBuilder res = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(ind < spaces.length && i== spaces[ind]){
                ind++;
                res.append(" ");
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}