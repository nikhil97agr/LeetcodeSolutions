class Solution {
    public String greatestLetter(String s) {
        boolean low[] = new boolean[26];
        boolean up[] = new boolean[26];

        for(char c : s.toCharArray()){
            if(Character.isLowerCase(c)){
                low[c-'a'] = true;
            }
            else{
                up[c-'A'] = true;
            }
        }

        for(int i=25;i>=0;i--){
            if(up[i] && low[i]){
                return ""+(char)('A'+i);
            }
        }

        return "";
    }
}