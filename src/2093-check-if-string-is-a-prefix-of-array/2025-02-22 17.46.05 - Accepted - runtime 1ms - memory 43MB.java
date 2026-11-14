class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String res = "";
        for(String st : words){
            res += st;
            if(res.equals(s)) return true;
        }
        return false;
    }
}