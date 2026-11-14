class Solution {
    public boolean checkTwoChessboards(String s1, String s2) {
        String c1 = getClr(s1);
        String c2 = getClr(s2);
        
        return c1.equals(c2);
    }
    
    private String getClr(String s){
        int ind1 = s.charAt(0)-'a';
        int ind2 = s.charAt(1)-'0';
        
        if(ind1%2 != ind2%2) return "Black";
        return "White";
    }
}