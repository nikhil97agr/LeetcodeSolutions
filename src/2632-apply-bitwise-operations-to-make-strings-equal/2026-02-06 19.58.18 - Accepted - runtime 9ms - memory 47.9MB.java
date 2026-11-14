class Solution {
    public boolean makeStringsEqual(String s, String t) {
        int n = s.length();
        int z1 = 0;
        int z2 = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '0'){
                z1++;
            }
            if(t.charAt(i) == '0'){
                z2++;
            }
        }

        if(z1 == n && z2 == n) return true;
        if(z1 == n || z2 == n) return false;
        return true;

    }
}