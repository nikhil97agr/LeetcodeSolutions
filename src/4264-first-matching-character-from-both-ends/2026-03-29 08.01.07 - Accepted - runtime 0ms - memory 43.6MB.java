class Solution {
    public int firstMatchingIndex(String s) {
        int n =s.length();
        for(int i=0, j= n-1;i<=j;i++,j--){
            if(s.charAt(i) == s.charAt(j)) return i;
        }
        return -1;
    }
}