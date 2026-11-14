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